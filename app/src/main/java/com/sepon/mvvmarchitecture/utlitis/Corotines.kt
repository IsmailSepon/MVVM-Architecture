package com.sepon.mvvmarchitecture.utlitis

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Corotines{

    fun main(work : suspend (()->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    //for store localdatabase
    fun io(work : suspend (()->Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }


}