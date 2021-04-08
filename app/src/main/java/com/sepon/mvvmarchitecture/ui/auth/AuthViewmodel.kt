package com.sepon.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.sepon.mvvmarchitecture.repository.UserRepository

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

        val loginresponse = UserRepository().userLogin(email!! , password!!)

        authInterface?.onSucsess(loginresponse)

    }


}