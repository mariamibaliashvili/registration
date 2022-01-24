package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var editTextEmail:EditText
    private lateinit var editTextPassword : EditText
    private lateinit var editTextPasswordConfirm : EditText
    private lateinit var buttonRegister : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration2)

        init()

        registerListener()

    }

    private fun init(){
        editTextEmail=findViewById(R.id.editTextEmail)
        editTextPassword=findViewById(R.id.editTextPassword)
        editTextPasswordConfirm=findViewById(R.id.editTextPasswordConfirm)
        buttonRegister=findViewById(R.id.buttonRegister)
    }

    private fun registerListener(){
        buttonRegister.setOnClickListener() {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val pass = editTextPasswordConfirm.text.toString()

            if (pass != password) {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty() || password.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "თქვენ წარმატებით დარეგისტრირდით!", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}