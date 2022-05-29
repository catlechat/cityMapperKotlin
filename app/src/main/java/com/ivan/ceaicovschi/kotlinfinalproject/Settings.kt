package com.ivan.ceaicovschi.kotlinfinalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val chooseCity = findViewById<View>(R.id.choose_city) as Button
        chooseCity.setOnClickListener {
            intent = Intent(this@Settings, ChooseCity::class.java)
            startActivity(intent)
            finish()
        }

        val backButton = findViewById<View>(R.id.backButton) as Button
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}