package com.sepon.mvvmarchitecture.network

import android.content.Context
import android.net.ConnectivityManager
import com.sepon.mvvmarchitecture.utlitis.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetConnectionIntercepter(
    context: Context
) : Interceptor {

    private val context = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if (!getConntection())
            throw NoInternetException("No Internet")

        return chain.proceed(chain.request())

    }


    fun getConntection() : Boolean{

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {

            return it != null && it.isConnected
        }


    }
}