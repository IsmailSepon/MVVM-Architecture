package com.sepon.mvvmarchitecture.network.response

import com.sepon.mvvmarchitecture.data.entity.User

data class AuthResponse (
    val isSuccessfull : Boolean,
    val message : String,
    val user : User?
        )