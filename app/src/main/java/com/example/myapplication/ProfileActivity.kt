package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class ProfileActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var buttonPasswordChange:Button
    private lateinit var buttonLogout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile2)

        init()

        registerListener()

        textView.text = FirebaseAuth.getInstance().currentUser?.uid


    }

    private fun init(){
        textView=findViewById(R.id.textView)
        buttonPasswordChange=findViewById(R.id.buttonPasswordChange)
        buttonLogout=findViewById(R.id.buttonLogout)
    }

    private fun registerListener(){
        buttonLogout.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        buttonPasswordChange.setOnClickListener(){
            startActivity(Intent(this, PasswordChangeActivity::class.java))

        }

    }
}