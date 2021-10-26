package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignIn : AppCompatActivity() {

    private lateinit var edMob: EditText
    private lateinit var edPa: EditText
    private lateinit var btnSignIn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        edMob = findViewById(R.id.edMob)
        edPa = findViewById(R.id.edPa)
        btnSignIn = findViewById(R.id.btnSignIn)

        btnSignIn.setOnClickListener {

            val dbHlpr = DBHlpr(applicationContext)
            val user = dbHlpr.retrive(edMob.text.toString(), edPa.text.toString())
            if (user != null) {
                val intent = Intent(applicationContext, Details::class.java)
                intent.putExtra("name", user.name)
                intent.putExtra("mobile", user.mobile)
                intent.putExtra("location", user.loction)
                startActivity(intent)
            }


        }
    }
}