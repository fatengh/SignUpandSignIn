package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SginUp : AppCompatActivity() {

    private lateinit var edName:EditText
    private lateinit var edMobile:EditText
    private lateinit var edLoc:EditText
    private lateinit var edPass:EditText
    private lateinit var btnSignUp:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sgin_up)

        edName = findViewById(R.id.edName)
        edMobile = findViewById(R.id.edMobile)
        edLoc = findViewById(R.id.edLoc)
        edPass = findViewById(R.id.edPass)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            if (edName.text.isNotEmpty() && edMobile.text.isNotEmpty() &&
                edLoc.text.isNotEmpty() && edPass.text.isNotEmpty()
            ) {
                var dbhr = DBHlpr(applicationContext)

                var s = dbhr.saveData(
                    edName.text.toString(),
                    edMobile.text.toString(),
                    edLoc.text.toString(),
                    edPass.text.toString()
                )
                Toast.makeText(this, "User added $s", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "One or more fields is empty", Toast.LENGTH_LONG).show()
            }
            intent = Intent(applicationContext, Details::class.java)
            intent.putExtra("name",edName.text.toString())
            intent.putExtra("mobile",edMobile.text.toString())
            intent.putExtra("location",edLoc.text.toString())
            startActivity(intent)
        }


        }
    }
