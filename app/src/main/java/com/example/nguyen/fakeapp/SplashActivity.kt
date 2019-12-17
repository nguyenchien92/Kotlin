package com.example.nguyen.fakeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import com.example.nguyen.fakeapp.utils.MoveTo
import java.lang.Thread.sleep

class SplashActivity : AppCompatActivity(), MoveTo {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splass_activity)

        move(supportFragmentManager)
    }


    private fun waiting() {
        val thread = object : Thread() {
            override fun run() {
                sleep(1000)
                var intentActivity = Intent(baseContext, MainActivity::class.java)
                startActivity(intentActivity)
            }
        }
        thread.start()
    }

    override fun move(manager: FragmentManager) {
        waiting()
    }
}
