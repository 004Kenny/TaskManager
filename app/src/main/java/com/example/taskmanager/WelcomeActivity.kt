package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val userName = findViewById<EditText>(R.id.edtUsername)
        val password = findViewById<EditText>(R.id.edtPassword)
        val forgotPassword = findViewById<TextView>(R.id.textForgotPassword)
        val signInButton = findViewById<Button>(R.id.buttonLogin)
        val signUp = findViewById<TextView>(R.id.txtSignUp)

        signUp.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        forgotPassword.setOnClickListener{
            val startFPIntent = Intent(this, ForgotPassword::class.java)
            startActivity(startFPIntent)
        }



    }
}