package com.sepon.mvvmarchitecture.ui

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIServices {

    @FormUrlEncoded
    @POST("login")
    fun userlogin(
            @Field("email") email : String,
            @Field("password") passdord : String
    ) : Call<ResponseBody>


    companion object{
        open operator fun invoke() : APIServices{
            return Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(APIServices::class.java)
        }
    }




}