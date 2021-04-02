package com.sepon.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewmodel : ViewModel() {


    var email : String? = null
    var password : String? = null
    var authInterface : AuthInterface? = null



    fun onLoginClick(view : View){

        authInterface?.onstart()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()){

            authInterface?.onFailur("Invlaid input")

            return
        }


        authInterface?.onSucsess()

    }


}