package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnSI : Button
    private lateinit var btnSU : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSI = findViewById(R.id.btnSI)
        btnSU = findViewById(R.id.btnSU)

        btnSI.setOnClickListener {
            intent = Intent(applicationContext, SignIn::class.java)
            startActivity(intent)
        }
        btnSU.setOnClickListener {
            intent = Intent(applicationContext, SginUp::class.java)
            startActivity(intent)
        }
    }
}