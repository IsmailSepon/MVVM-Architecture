package com.sepon.mvvmarchitecture.ui

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(msg : String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun logError(tag : String, msg : String){
    Log.e(tag, msg)
}