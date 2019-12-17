package com.example.nguyen.fakeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.nguyen.fakeapp.R
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.viewmodels.SignUpViewModel

class FragSignUp : Fragment() {

    private var rootView: View? = null
    private var edFullName: EditText? = null
    private var edEmail: EditText? = null
    private var edPhoneNumber: EditText? = null
    private var edPassWord: EditText? = null
    private var tvRegister: TextView? = null
    private var checkBox: CheckBox? = null
    private var map = HashMap<String, String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.sign_up_frag, container, false)

        init()

        tvRegister?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (checkBox!!.isChecked) {

                    //error message response
                    registerUser()
                } else {
                    Toast.makeText(context, resources?.getString(R.string.all_tv_rule), Toast.LENGTH_SHORT).show()
                }
            }
        })


        return rootView
    }

    private fun registerUser() {

        var mViewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        mViewModel.queryRepo(map!!)
        mViewModel?.executeRegister()?.observe(this,
            Observer<LoginInfo> { t ->
                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
            })

    }

    private fun formDataRegister() {
        var name = edFullName?.text.toString()
        var mail = edEmail?.text.toString()
        var phoneNumber = edPhoneNumber?.text.toString()
        var pass = edPassWord?.text.toString()

        map["name"] = name
        map["mail"] = mail
        map["phoneNumber"] = phoneNumber
        map["pass"] = pass

    }

    private fun init() {
        edFullName = rootView?.findViewById(R.id.ed_full_name)
        edEmail = rootView?.findViewById(R.id.ed_mail)
        edPhoneNumber = rootView?.findViewById(R.id.ed_phone_number)
        edPassWord = rootView?.findViewById(R.id.ed_pass_word)
        tvRegister = rootView?.findViewById(R.id.tv_register)
        checkBox = rootView?.findViewById(R.id.checkbox)

        formDataRegister()

    }
}


