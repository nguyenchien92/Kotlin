package com.example.nguyen.fakeapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.models.LoginInfoRepo

class LoginViewModel : ViewModel() {
    private var repo: LoginInfoRepo? = LoginInfoRepo.getInstance()
    private var mResult: MutableLiveData<LoginInfo>? = null

    fun getData(): MutableLiveData<LoginInfo>? {
        mResult=  repo?.loginData
        return mResult
    }

    fun queryRepoEmail(email: String, password: String) {
        repo?.checkLogin(email, password)
    }

}