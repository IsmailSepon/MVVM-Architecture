package com.sepon.mvvmarchitecture.repository

import com.sepon.mvvmarchitecture.network.APIServices
import com.sepon.mvvmarchitecture.network.ApiRequest
import com.sepon.mvvmarchitecture.network.response.AuthResponse
import retrofit2.Response

class UserRepository : ApiRequest() {

   suspend fun userLogin(email : String, password : String ): AuthResponse{

       return apiResuest{ APIServices().userlogin(email, password)}

    }
}