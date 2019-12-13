package com.example.nguyen.fakeapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.nguyen.fakeapp.R
import com.example.nguyen.fakeapp.viewmodels.LoginViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.nguyen.fakeapp.models.LoginInfo


class FragLogin : Fragment() {

    var edMail: EditText? = null
    var edPass: EditText? = null
    var tvSignIn: TextView? = null
    var tvSignUp: TextView? = null
    var mDataViewModel: LoginViewModel? = null

    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.login_frag, container, false)

        init()
        tvSignIn?.setOnClickListener { signInEvent() }

        return rootView
    }

    private fun signInEvent() {
        getData()
    }

    private fun getData() {


        mDataViewModel = ViewModelProviders.of(this)
            .get(LoginViewModel::class.java)

        mDataViewModel?.getData(edMail?.text.toString(),edPass?.text.toString())?.observe(this, object : Observer<LoginInfo> {
            override fun onChanged(t: LoginInfo?) {
                Toast.makeText(context,t?.data?.email,Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun init() {
        edMail = rootView?.findViewById(R.id.ed_mail)
        edPass = rootView?.findViewById(R.id.ed_pass_word)

        tvSignIn = rootView?.findViewById(R.id.tv_sign_in)
        tvSignUp = rootView?.findViewById(R.id.tv_sign_up)



    }


}