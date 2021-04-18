package com.sepon.mvvmarchitecture.network

import com.google.gson.JsonObject
import com.sepon.mvvmarchitecture.network.response.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServices {

    @FormUrlEncoded
    @POST("login")
    suspend fun userlogin(
            @Field("email") email : String,
            @Field("password") passdord : String
    ) : Response<AuthResponse>




    @FormUrlEncoded
    @POST("signin")
    suspend fun userSignUp(
            @Field("name") name : String,
            @Field("email") email : String,
            @Field("password") passdord : String
    ) : Response<AuthResponse>




    @GET("fuck")
    suspend fun getData() : Response<JsonObject>













    companion object{
        open operator fun invoke(
            networkIntercepter : NetConnectionIntercepter
        ) : APIServices {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkIntercepter)
                .build()




                return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(APIServices::class.java)
        }
    }




}