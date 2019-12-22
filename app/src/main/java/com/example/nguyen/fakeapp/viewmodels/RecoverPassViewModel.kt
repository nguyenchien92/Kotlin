package com.example.nguyen.fakeapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.models.LoginInfoRepo
import com.example.nguyen.fakeapp.models.RecoverPassRepo

class RecoverPassViewModel : ViewModel(){
    private var repo: RecoverPassRepo? = RecoverPassRepo.getInstance()

    fun responseResult(): MutableLiveData<LoginInfo>? {

        return repo?.mResult
    }

    fun executedRecoverPass(email:String){
        repo?.recoverMail(email)
    }
}