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
import androidx.lifecycle.ViewModelProviders
import com.example.nguyen.fakeapp.R
import com.example.nguyen.fakeapp.models.LoginInfo
import com.example.nguyen.fakeapp.viewmodels.RecoverPassViewModel

class FragRecoverPassWord : Fragment() {

    private var rootView: View? = null
    private var edRecoverMail: EditText? = null
    private var tvExecuteRecover: TextView? = null
    private var mViewModel: RecoverPassViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.recover_pass_frag, container, false)

        init()

        tvExecuteRecover?.setOnClickListener {
            var email = edRecoverMail?.text.toString()
            mViewModel?.executedRecoverPass(email)
        }

        return rootView
    }


    private fun init() {
        edRecoverMail = rootView?.findViewById(R.id.ed_recover_mail)
        tvExecuteRecover = rootView?.findViewById(R.id.tv_execute_recover)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(RecoverPassViewModel::class.java)
        mViewModel?.responseResult()?.observe(this,
            Observer<LoginInfo> { t ->
                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
                Log.d("TEST2", "[onChanged]: " + hashCode())
            })
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mViewModel = ViewModelProviders.of(this).get(RecoverPassViewModel::class.java)
//
//        mViewModel?.responseResult()?.observe(viewLifecycleOwner,
//            Observer<LoginInfo> { t ->
//                Toast.makeText(context, "${t?.message}", Toast.LENGTH_SHORT).show()
//                Log.d("TEST2", "[onChanged]: " + hashCode())
//            })
//    }
}