package com.example.nguyen.fakeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nguyen.fakeapp.R
import kotlinx.android.synthetic.main.content_main_frag.view.*

class FragContentMain : Fragment() {

    private var rootView: View? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.content_main_frag,container,false)

        return rootView
    }
}