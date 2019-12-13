package com.example.nguyen.fakeapp.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nguyen.fakeapp.utils.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginInfoRepo {


    companion object {

        var loginInstance: LoginInfoRepo ?= LoginInfoRepo()
        var loginData: MutableLiveData<LoginInfo> ?= MutableLiveData()

        fun getInstance(): LoginInfoRepo? {
            if (loginInstance == null)
                loginInstance = LoginInfoRepo()

            return loginInstance
        }
    }


    fun getDataLogin(email:String,password:String): MutableLiveData<LoginInfo>? {
        getData(email,password)

        return loginData
    }

    private fun getData(email:String,password:String) {

        var client:ApiService = ControllerApi.getClient().create(ApiService::class.java)
        var call = client.getDataLogin(email,password)

        call.enqueue(object: Callback<LoginInfo>{
            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                Log.d("Fail","${t.localizedMessage}")
            }

            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
               loginData?.value = response.body()
            }
        })
    }
}