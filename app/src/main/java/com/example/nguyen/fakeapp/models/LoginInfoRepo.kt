package com.example.nguyen.fakeapp.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nguyen.fakeapp.utils.ApiService
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginInfoRepo {

    val loginData: MutableLiveData<LoginInfo> = MutableLiveData()

    companion object {
        var loginInstance: LoginInfoRepo? = null
        fun getInstance(): LoginInfoRepo? {
            if (loginInstance == null)
                loginInstance = LoginInfoRepo()

            return loginInstance
        }
    }

    fun getInstance(): LoginInfoRepo? {
        if (loginInstance == null)
            loginInstance = LoginInfoRepo()

        return loginInstance
    }


    fun checkLogin(email: String, password: String) {
        var client: ApiService = ControllerApi.getClient().create(ApiService::class.java)
        var call = client.getDataLogin(email, password)

//        val result = MutableLiveData<LoginInfo>()

        call.enqueue(object : Callback<LoginInfo> {
            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                Log.d("Fail", "${t.localizedMessage}")
            }

            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {

                var code = response.code()
                when (code) {
                    404 -> errorData(response)
                    200 -> resultData(response)
                }
            }
        })
    }

//    private fun getData( email: String, password: String) {
//
//        var client: ApiService = ControllerApi.getClient().create(ApiService::class.java)
//        var call = client.getDataLogin(email, password)
//
//        call.enqueue(object : Callback<LoginInfo> {
//            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
//                Log.d("Fail", "${t.localizedMessage}")
//            }
//
//            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
//
//                var code = response.code()
//                when (code) {
//                    404 -> errorData(response)
//                    200 -> resultData(response)
//                }
//            }
//        })
//    }

    private fun errorData(response: Response<LoginInfo>) {
        var gson = Gson()
        var errorResult = gson.fromJson(response.errorBody()?.string(),LoginInfo::class.java)

        loginData?.value = errorResult
    }

    private fun resultData(response: Response<LoginInfo>) {
        loginData?.value = response.body()
    }

}


