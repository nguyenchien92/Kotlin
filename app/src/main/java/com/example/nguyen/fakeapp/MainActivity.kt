package com.example.nguyen.fakeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import com.example.nguyen.fakeapp.fragments.FragLogin
import com.example.nguyen.fakeapp.utils.MoveTo

class MainActivity : AppCompatActivity() ,MoveTo{
    private var frameMain :FrameLayout ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        move()
    }

    private fun init()
    {
        frameMain = findViewById(R.id.frame_layout_activity)
    }

    override fun move() {
        var manager:FragmentManager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_layout_activity,FragLogin(),FragLogin::class.java.simpleName)
        transaction.commit()
    }
}
