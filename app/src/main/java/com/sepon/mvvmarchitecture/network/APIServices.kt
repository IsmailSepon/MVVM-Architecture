package com.sepon.mvvmarchitecture.network

import com.sepon.mvvmarchitecture.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIServices {

    @FormUrlEncoded
    @POST("login")
    suspend fun userlogin(
            @Field("email") email : String,
            @Field("password") passdord : String
    ) : Response<AuthResponse>


    companion object{
        open operator fun invoke() : APIServices {
            return Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(APIServices::class.java)
        }
    }




}