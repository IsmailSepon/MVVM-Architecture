package com.sepon.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.sepon.mvvmarchitecture.repository.UserRepository
import com.sepon.mvvmarchitecture.utlitis.Corotines
import com.sepon.mvvmarchitecture.utlitis.NoInternetException

class AuthViewmodel(
    private val repository : UserRepository
) : ViewModel() {


    var email : String? = null
    var password : String? = null
    var authInterface : AuthInterface? = null
    fun getLoggedUser() = repository.getUser()



    fun onLoginClick(view : View){

        authInterface?.onstart()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authInterface?.onFailur("Invlaid input")
            return
        }

        Corotines.main {

            try {

                val authresponse = repository.userLogin(email!!, password!!)
                authresponse.user?.let {
                    authInterface?.onSucsess(it)
                    repository.saveUser(it)
                    return@main
                }
                authInterface?.onFailur(authresponse.message)
            }catch (e : Exception){
                authInterface?.onFailur(e.message!!)
            }catch (e: NoInternetException){
                authInterface?.onFailur(e.message!!)
            }

        }


    }


}