package com.example.nguyen.fakeapp.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nguyen.fakeapp.utils.ApiService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpRepo private constructor() {
    companion object {
        val mResult: MutableLiveData<LoginInfo> = MutableLiveData()
        var signUpRepo: SignUpRepo? = null

        fun getInstance(): SignUpRepo? {
            if (signUpRepo == null)
                signUpRepo = SignUpRepo()

            return signUpRepo
        }
    }

    fun checkSignUp(mapInfo: Map<String, String>) {

        var client = ControllerApi.getClient().create(ApiService::class.java)
        var call = client.register(mapInfo)

        call.enqueue(object : Callback<LoginInfo> {
            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                Log.d("Fail", "${t.localizedMessage}")
            }

            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
                var code = response.code()

                when (code) {
                    EnumCode.ERROR.number -> errorData(response)
                    EnumCode.SUCCESS.number -> successData(response)
                }
            }
        })
    }

    private fun successData(response: Response<LoginInfo>) {
        mResult.value = response.body()
    }

    private fun errorData(response: Response<LoginInfo>) {
        var gson = Gson()
        var result = gson.fromJson(response.errorBody()?.string(), LoginInfo::class.java)

        mResult.value = result
    }
}