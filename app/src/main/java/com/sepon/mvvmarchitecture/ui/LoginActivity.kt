 package com.sepon.mvvmarchitecture.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sepon.mvvmarchitecture.R
import com.sepon.mvvmarchitecture.data.AppDatabase
import com.sepon.mvvmarchitecture.data.entity.User
import com.sepon.mvvmarchitecture.databinding.ActivityMainBinding
import com.sepon.mvvmarchitecture.network.APIServices
import com.sepon.mvvmarchitecture.network.NetConnectionIntercepter
import com.sepon.mvvmarchitecture.repository.UserRepository
import com.sepon.mvvmarchitecture.ui.auth.AuthInterface
import com.sepon.mvvmarchitecture.ui.auth.AuthViewModelFactory
import com.sepon.mvvmarchitecture.ui.auth.AuthViewmodel

 class LoginActivity : AppCompatActivity() , AuthInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val netIntercepter = NetConnectionIntercepter(this)
        val api = APIServices(netIntercepter)
        val db = AppDatabase(this)
        val repository = UserRepository(api, db)
        val factory = AuthViewModelFactory(repository)

       // setContentView(R.layout.activity_main)
        val bindig : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewmodel = ViewModelProviders.of(this, factory).get(AuthViewmodel::class.java)
        bindig.viewModel = viewmodel
        viewmodel.authInterface = this


        viewmodel.getLoggedUser().observe(this, Observer { user ->
            if (user != null){
                // user already logged in
                Intent(this, SignUpActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK    //flag need to open a new activity
                    startActivity(it)
                }

            }

        })

    }

     override fun onstart() {

         toast("login start")
     }

     override fun onSucsess(user : User) {

        toast("${user.username} is logged IN ")
     }

     override fun onFailur(msg: String) {

         toast(msg)
         logError("login", msg)
     }
 }