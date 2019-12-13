package com.example.nguyen.fakeapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.models.LoginInfoRepo

class LoginViewModel : ViewModel() {
    private var dataLogin : MutableLiveData<LoginInfo> ?= null
    private var repo:LoginInfoRepo ?=null

    fun getData(email:String,password:String):MutableLiveData<LoginInfo>?{
        queryRepo(email,password)
        return dataLogin
    }

    private fun queryRepo(email:String,password:String) {
        repo = LoginInfoRepo.getInstance()

        dataLogin = repo?.getDataLogin(email, password)
    }
}