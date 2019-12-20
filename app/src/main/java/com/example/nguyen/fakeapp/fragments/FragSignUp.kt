package com.example.nguyen.fakeapp.fragments

import android.annotation.SuppressLint
import android.content.Context
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
    private var mViewModel: SignUpViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.sign_up_frag, container, false)

        init()

//        setChangeColorLineEditText()

        tvRegister?.setOnClickListener {
            if (checkBox!!.isChecked) {
                registerUser()
            } else {
                Toast.makeText(
                    context,
                    resources?.getString(R.string.all_tv_rule),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        return rootView
    }

    private fun setChangeColorLineEditText() {

        var changeColor = View.OnClickListener { view ->
            view.background.setTint(view.resources.getColor(R.color.colorAccent,null))
        }

        edFullName?.setOnClickListener(changeColor)
        edEmail?.setOnClickListener(changeColor)
        edPhoneNumber?.setOnClickListener(changeColor)
        edPassWord?.setOnClickListener(changeColor)
    }

    private fun registerUser() {
        var name = edFullName?.text.toString()
        var mail = edEmail?.text.toString()
        var phoneNumber = edPhoneNumber?.text.toString()
        var pass = edPassWord?.text.toString()

        var map = mutableMapOf(
            "email" to mail,
            "name" to name,
            "phone_number" to phoneNumber,
            "password" to pass
        )

        mViewModel?.queryRepo(map)

    }


    private fun init() {
        edFullName = rootView?.findViewById(R.id.ed_full_name)
        edEmail = rootView?.findViewById(R.id.ed_mail)
        edPhoneNumber = rootView?.findViewById(R.id.ed_phone_number)
        edPassWord = rootView?.findViewById(R.id.ed_pass_word)
        tvRegister = rootView?.findViewById(R.id.tv_register)
        checkBox = rootView?.findViewById(R.id.checkbox)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        mViewModel?.executeRegister()?.observe(this,
            Observer<LoginInfo> { t ->
                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
            })
    }
}


