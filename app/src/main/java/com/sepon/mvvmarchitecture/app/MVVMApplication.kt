package com.sepon.mvvmarchitecture.app

import android.app.Application
import com.sepon.mvvmarchitecture.data.AppDatabase
import com.sepon.mvvmarchitecture.network.APIServices
import com.sepon.mvvmarchitecture.network.NetConnectionIntercepter
import com.sepon.mvvmarchitecture.repository.UserRepository
import com.sepon.mvvmarchitecture.ui.auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import java.net.NetworkInterface

class MVVMApplication : Application(), KodeinAware{


    override val kodein = Kodein.lazy {

        //import(androidxModule(this@MVVMApplication))

        bind() from singleton { NetConnectionIntercepter(instance()) }
        bind() from singleton { APIServices(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
    }

}