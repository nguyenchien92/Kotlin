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

    private var edMail: EditText? = null
    private var edPass: EditText? = null
    private var tvSignIn: TextView? = null
    private var tvSignUp: TextView? = null
    private var mDataViewModel: LoginViewModel? = null

    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.login_frag, container, false)

        init()
        setEventClick()
        mDataViewModel = ViewModelProviders.of(this)
            .get(LoginViewModel::class.java)

        mDataViewModel?.getData()?.observe(this,
            Observer<LoginInfo> { t ->
                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
            })

        return rootView
    }


    private fun setEventClick() {

        tvSignUp?.setOnClickListener { signUp() }

        tvSignIn?.setOnClickListener { signIn() }
    }

    private fun signUp() {
        Toast.makeText(context, tvSignUp?.text.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun signIn() {
        checkLogin()
    }

    private fun checkLogin() {

        var email = edMail?.text.toString()
        var pass = edPass?.text.toString()

        getDataLogin(email, pass)
    }


    private fun getDataLogin(email: String, pass: String) {
        mDataViewModel?.queryRepo(email, pass)

    }

    private fun init() {
        edMail = rootView?.findViewById(R.id.ed_mail)
        edPass = rootView?.findViewById(R.id.ed_pass_word)

        tvSignIn = rootView?.findViewById(R.id.tv_sign_in)
        tvSignUp = rootView?.findViewById(R.id.tv_sign_up)

    }


}
