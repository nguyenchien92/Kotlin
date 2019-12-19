package com.example.nguyen.fakeapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.models.SignUpRepo

class SignUpViewModel : ViewModel() {
    private var repo: SignUpRepo? = SignUpRepo.getInstance()

    fun executeRegister():MutableLiveData<LoginInfo>?{
        return repo?.mResult
    }

    fun queryRepo(map:Map<String,String>){
        repo?.checkSignUp(map)
    }
}
