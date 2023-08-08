package com.example.testapp

import BaseActivity
import android.os.Bundle
import android.widget.EditText

class LoginActivity : BaseActivity(){
lateinit var etMail : EditText
lateinit var etPass : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()


    }
}