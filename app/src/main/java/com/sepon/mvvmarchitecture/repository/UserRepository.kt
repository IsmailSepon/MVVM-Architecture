package com.sepon.mvvmarchitecture.repository

import com.sepon.mvvmarchitecture.data.AppDatabase
import com.sepon.mvvmarchitecture.data.entity.User
import com.sepon.mvvmarchitecture.network.APIServices
import com.sepon.mvvmarchitecture.network.ApiRequest
import com.sepon.mvvmarchitecture.network.response.AuthResponse
import retrofit2.Response

class UserRepository(
        private val api : APIServices,
        private val db : AppDatabase


) : ApiRequest() {

   suspend fun userLogin(email : String, password : String ): AuthResponse{

       return apiResuest{ api.userlogin(email, password)}

    }

    suspend fun saveUser(user: User) = db.getUserDao().insertUser(user)
    fun getUser() = db.getUserDao().getUser()

}