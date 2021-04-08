package com.sepon.mvvmarchitecture.ui.auth

import androidx.lifecycle.LiveData

interface AuthInterface {

    fun onstart()
    fun onSucsess(loginresponse: LiveData<String>)
    fun onFailur(msg : String)

}