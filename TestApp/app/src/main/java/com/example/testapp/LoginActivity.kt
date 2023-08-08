package com.example.testapp

import BaseActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity(){
lateinit var etMail : EditText
lateinit var etPass : EditText
lateinit var loginBtn : Button
val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        etMail=findViewById(R.id.login_mail)
        etPass=findViewById(R.id.login_password)
        loginBtn=findViewById(R.id.btn_login)
        val progressBar = findViewById<ProgressBar>(R.id.login_progress_bar)
        progressBar.bringToFront()
        progressBar.invalidate()
        loginBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val  email = etMail.text.toString().trim()
            val password = etPass.text.toString().trim()
            if(email.isEmpty() || password.isEmpty()|| !email.matches(emailPattern.toRegex())){
                if (!email.matches(emailPattern.toRegex())) {

                   etMail.error="Enter valid email!"
                }
                if (email.isEmpty()){
                    etMail.error = "Enter email!"
                }
                if ( password.isEmpty()){
                    etPass.error="Enter password"
                }
                progressBar.visibility = View.GONE
            }else{
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnSuccessListener {
                    Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, "Failed chack your informations", Toast.LENGTH_SHORT).show()
                }
                etMail.text.clear()
                etPass.text.clear()
                progressBar.visibility = View.GONE

            }

        }
    }
}