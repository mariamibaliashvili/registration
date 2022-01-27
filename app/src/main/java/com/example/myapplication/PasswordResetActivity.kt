package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class PasswordResetActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSendEmail: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset2)

        init()

        registerListener()
    }

    private fun init(){
        buttonSendEmail=findViewById(R.id.buttonSendEmail)
        editTextEmail=findViewById(R.id.editTextEmail)
    }

    private fun registerListener(){

        buttonSendEmail.setOnClickListener() {
            val email = editTextEmail.text.toString()

            if (email.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Check email", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }

                }

        }
    }
}