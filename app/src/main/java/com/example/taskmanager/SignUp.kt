package com.example.taskmanager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpUsername = findViewById<EditText>(R.id.edtUsernameSignUp)
        val signUpPassword = findViewById<EditText>(R.id.edtPasswordSignUp)
        val signUpConfirmPassword = findViewById<EditText>(R.id.edtConfirmPassword)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        val sharedPreferences = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)

        signUpButton.setOnClickListener {
            val username = signUpUsername.text.toString().trim()
            val password = signUpPassword.text.toString()
            val confirmPassword = signUpConfirmPassword.text.toString()

            when {
                username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                }
                isUsernameTaken(sharedPreferences, username) -> {
                    Toast.makeText(this, "Username already taken", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    saveUser(sharedPreferences, username, password)
                    Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()
                    finish()
                }

            }

        }

    }

    private fun isUsernameTaken (sharedPreferences: SharedPreferences, username: String): Boolean{
        return sharedPreferences.contains(username)
    }

    private fun saveUser(sharedPreferences: SharedPreferences, username: String, password: String){
        val editor = sharedPreferences.edit()
        editor.putString(username, password)
        editor.apply()
    }
}