package com.sepon.mvvmarchitecture.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sepon.mvvmarchitecture.data.entity.CURRENT_USER_ID
import com.sepon.mvvmarchitecture.data.entity.User


@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : User) : Long


    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}