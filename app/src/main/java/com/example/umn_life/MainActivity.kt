package com.example.umn_life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set onClickListener on login button
        btnLogin.setOnClickListener {
            //Check if the input fields are empty
            if(etUsername.text.isEmpty() || etPassword.text.isEmpty()){
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_SHORT).show()
            } else {
                //Get the values from the input fields
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                //Check the credentials against the database
                if(username == "admin" && password == "admin"){
