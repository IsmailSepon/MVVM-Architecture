package com.sepon.mvvmarchitecture.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sepon.mvvmarchitecture.data.entity.User
import java.util.concurrent.locks.Lock

@Database(
    entities = [User ::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getUserDao() : UserDao

    companion object{

        @Volatile
        private var instanse : AppDatabase? = null
        private val lock = Any()


        operator fun invoke(context: Context) = instanse ?: synchronized(lock){
            instanse?: buildDatabase(context).also {
                instanse = it
            }

        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "MyDatabase"
        ).build()



    }


}