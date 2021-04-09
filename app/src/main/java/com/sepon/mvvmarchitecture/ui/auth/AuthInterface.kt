package com.sepon.mvvmarchitecture.ui.auth

import androidx.lifecycle.LiveData
import com.sepon.mvvmarchitecture.data.entity.User

interface AuthInterface {

    fun onstart()
    fun onSucsess(user : User)
    fun onFailur(msg : String)

}