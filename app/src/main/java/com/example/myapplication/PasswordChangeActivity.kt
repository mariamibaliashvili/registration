package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextPassword: EditText
    private lateinit var buttonPasswordChange : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change2)

        init()

        registerListener()
    }

    private fun init(){
        editTextPassword=findViewById(R.id.editTextPassword)
        buttonPasswordChange=findViewById(R.id.buttonPasswordChange)
    }

    private fun registerListener(){
        buttonPasswordChange.setOnClickListener(){
            val newPassword = editTextPassword.text.toString()

            if (newPassword.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth
                .getInstance()
                .currentUser
                ?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}