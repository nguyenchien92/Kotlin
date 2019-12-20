package com.example.nguyen.fakeapp.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nguyen.fakeapp.utils.ApiService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecoverPassRepo{
    val mResult: MutableLiveData<LoginInfo> = MutableLiveData()
    companion object {

        private var recover: RecoverPassRepo? = null

        fun getInstance(): RecoverPassRepo? {
            if (recover == null) {
                recover = RecoverPassRepo()
            }

            return recover
        }
    }

    fun recoverMail(mail:String) {


        var client = ControllerApi.getClient().create(ApiService::class.java)
        var call = client.recoverPassWord(mail)

        call.enqueue(object : Callback<LoginInfo> {
            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                Log.d("Fail", "${t.localizedMessage}")
            }

            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
                var code = response.code()

                when (code) {
                    EnumCode.ERROR.number -> errorRegister(response)
                    EnumCode.SUCCESS.number -> successData(response)
                }
            }
        })
    }

    private fun successData(response: Response<LoginInfo>) {
        mResult?.value = response.body()
    }

    private fun errorRegister(response: Response<LoginInfo>) {
        var gson = Gson()

        var result = gson.fromJson(response.errorBody()?.string(), LoginInfo::class.java)

        mResult?.value = result
    }
}