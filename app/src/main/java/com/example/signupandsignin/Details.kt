package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {

    private lateinit var tvN: TextView
    private lateinit var tvD: TextView
    private lateinit var btnSO: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val name = intent.getStringExtra("name")
        val mobile = intent.getStringExtra("mobile")
        val location = intent.getStringExtra("location")
        tvN = findViewById(R.id.tvN)
        tvD = findViewById(R.id.tvD)
        btnSO = findViewById(R.id.btnSO)

        tvN.text = "Hello, $name"
        tvD.text = "Mobile: $mobile \n Loction: $location"

        btnSO.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }


    }
}