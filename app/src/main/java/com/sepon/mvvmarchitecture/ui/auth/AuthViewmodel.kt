package com.sepon.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.sepon.mvvmarchitecture.repository.UserRepository
import com.sepon.mvvmarchitecture.utlitis.Corotines

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

        Corotines.main {

            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful){

                authInterface?.onSucsess(response.body()?.user!!)
            }else{
                authInterface?.onFailur("Error Code ${response.body()}")
            }
        }


    }


}