package com.ivan.ceaicovschi.kotlinfinalproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class Launcher : AppCompatActivity() {
    private val TIME: Long = 2000; //timer to launch next activity
    private val mHandler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        mHandler.postDelayed({
            val intent = Intent(this@Launcher, ChooseCity::class.java)
            startActivity(intent)
        }, TIME)
    }
}