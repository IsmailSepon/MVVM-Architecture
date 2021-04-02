 package com.sepon.mvvmarchitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sepon.mvvmarchitecture.R
import com.sepon.mvvmarchitecture.databinding.ActivityMainBinding
import com.sepon.mvvmarchitecture.ui.auth.AuthInterface
import com.sepon.mvvmarchitecture.ui.auth.AuthViewmodel

 class LoginActivity : AppCompatActivity() , AuthInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        val bindig : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewmodel = ViewModelProviders.of(this).get(AuthViewmodel::class.java)
        bindig.viewModel = viewmodel



    }

     override fun onstart() {

         toast("login start")
     }

     override fun onSucsess() {

         toast("login Success")
     }

     override fun onFailur(msg: String) {

         toast(msg)
         logError("login", msg)
     }
 }