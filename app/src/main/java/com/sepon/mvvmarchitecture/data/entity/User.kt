package com.sepon.mvvmarchitecture.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
class User (
    val id : Int? = null,
    val username : String? = null,
    val mobile : Int? = null){

    @PrimaryKey(autoGenerate = false)
    var uid : Int = CURRENT_USER_ID

}