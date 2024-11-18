package com.example.taskmanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val usernameEdt = findViewById<EditText>(R.id.edtFPusername)
        val newPassword = findViewById<EditText>(R.id.edtFPpassword)
        val changePassword = findViewById<Button>(R.id.resetPasswordBtn)

        val sharedPreferences = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)

       changePassword.setOnClickListener {
            val username = usernameEdt.text.toString().trim()
            val passwordNew = newPassword.text.toString()

            when {
                username.isEmpty() || passwordNew.isEmpty() -> {
                    Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                }
                !(sharedPreferences).contains(username) -> {
                    Toast.makeText(this, "Username does not exist", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val editor = sharedPreferences.edit()
                    editor.putString(username, passwordNew)
                    editor.apply()

                    Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}