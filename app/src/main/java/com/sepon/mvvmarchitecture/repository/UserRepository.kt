package com.sepon.mvvmarchitecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sepon.mvvmarchitecture.ui.APIServices
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class UserRepository {

    fun userLogin(email : String, password : String ):LiveData<String>{

        val loginResponse = MutableLiveData<String>()
        APIServices().userlogin(email, password).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.isSuccessful){

                    loginResponse.value = response.body().toString()
                }else{
                    loginResponse.value = response.errorBody().toString()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                loginResponse.value = t.message
            }
        })

        return loginResponse
    }
}