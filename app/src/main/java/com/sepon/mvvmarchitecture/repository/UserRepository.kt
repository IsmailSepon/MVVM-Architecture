package com.sepon.mvvmarchitecture.repository

import com.sepon.mvvmarchitecture.network.APIServices
import com.sepon.mvvmarchitecture.network.response.AuthResponse
import retrofit2.Response

class UserRepository {

   suspend fun userLogin(email : String, password : String ): Response<AuthResponse>{

        return APIServices().userlogin(email, password)

    }
}