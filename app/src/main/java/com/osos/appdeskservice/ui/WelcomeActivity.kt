package com.osos.appdeskservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osos.appdeskservice.R
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.activity_main.*

class WelcomeActivity : AppCompatActivity() {



    lateinit var preferenceClass:PreferenceClass




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferenceClass= PreferenceClass(this)


        if(preferenceClass.getUsername()!=null){

        }

        // click listeners
        submit_username.setOnClickListener(){
           if(user_name.text.isNullOrEmpty()){
               user_name.setError("Please Enter Some User Name to Continue")
           }

       }

    }
}