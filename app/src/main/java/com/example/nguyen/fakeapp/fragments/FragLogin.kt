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
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.nguyen.fakeapp.R
import com.example.nguyen.fakeapp.viewmodels.LoginViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.nguyen.fakeapp.models.EnumCode
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.utils.MoveTo


class FragLogin : Fragment(), MoveTo {

    private var edMail: EditText? = null
    private var edPass: EditText? = null
    private var tvSignIn: TextView? = null
    private var tvSignUp: TextView? = null
    private var tvForgotPass: TextView? = null
    private var rootView: View? = null
    private var mDataViewModel: LoginViewModel? = null
    private var codeSuccess: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.login_frag, container, false)

        init()
        setEventClick()


        return rootView
    }


    private fun setEventClick() {

        tvSignUp?.setOnClickListener {
            signUp()
        }

        tvSignIn?.setOnClickListener { signIn() }

        tvForgotPass?.setOnClickListener(recoverPass())
    }

    private fun recoverPass() = View.OnClickListener {
        var transaction = fragmentManager?.beginTransaction()
        transaction?.replace(
            R.id.frame_layout_activity,
            FragRecoverPassWord(),
            FragRecoverPassWord::class.java.simpleName
        )
        transaction?.addToBackStack(FragRecoverPassWord::class.java.simpleName)
        transaction?.commit()
    }

    private fun signUp() {
        move(fragmentManager!!)
    }

    private fun signIn() {
        var email = edMail?.text.toString()
        var pass = edPass?.text.toString()

        getDataLogin(email, pass)

//        if (EnumCode.STATUS.number == codeSuccess){
//            var transaction = fragmentManager?.beginTransaction()
//            transaction?.replace(R.id.frame_layout_activity
//                ,FragContentMain(),FragContentMain::class.java.simpleName)
//            transaction?.addToBackStack(FragContentMain::class.java.simpleName)
//            transaction?.commit()
//        }
    }


    private fun getDataLogin(email: String, pass: String) {
        mDataViewModel?.queryRepoEmail(email, pass)
    }

    private fun init() {
        edMail = rootView?.findViewById(R.id.ed_mail)
        edPass = rootView?.findViewById(R.id.ed_pass_word)

        tvSignIn = rootView?.findViewById(R.id.tv_sign_in)
        tvSignUp = rootView?.findViewById(R.id.tv_sign_up)
        tvForgotPass = rootView?.findViewById(R.id.tv_forgot_pass_word)

    }

    override fun move(manager: FragmentManager) {
        var transaction = manager.beginTransaction()
        transaction.replace(
            R.id.frame_layout_activity,
            FragSignUp(),
            FragSignUp::class.java.simpleName
        )
        transaction.addToBackStack(FragSignUp::class.java.simpleName)
        transaction.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDataViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        mDataViewModel?.getData()?.observe(this,
            Observer<LoginInfo> { t ->
                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
                codeSuccess = t.status
                Log.d("TEST", "[onChanged]: " + hashCode())
            })
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mDataViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
//        mDataViewModel?.getData()?.removeObservers(viewLifecycleOwner)
//        mDataViewModel?.getData()?.observe(viewLifecycleOwner,
//            Observer<LoginInfo> { t ->
//                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
//                codeSuccess = t.status
//                Log.d("TEST", "[onChanged]: " + hashCode())
//            })
//
//    }

    override fun onPause() {
        super.onPause()
        edMail?.setText("")
        edPass?.setText("")
    }
}
//Đang gặp vấn đề chuyển trang sau khi xét điều kiện...