 package com.sepon.mvvmarchitecture.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sepon.mvvmarchitecture.R
import com.sepon.mvvmarchitecture.data.entity.User
import com.sepon.mvvmarchitecture.databinding.ActivitySignUpBinding
import com.sepon.mvvmarchitecture.ui.auth.AuthInterface
import com.sepon.mvvmarchitecture.ui.auth.AuthViewModelFactory
import com.sepon.mvvmarchitecture.ui.auth.AuthViewmodel
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

 class SignUpActivity : AppCompatActivity() , AuthInterface, KodeinAware{

     override val kodein by kodein()
     private val factory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_sign_up)

        val binding : ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        val viewmodel = ViewModelProviders.of(this, factory).get(AuthViewmodel::class.java)
        binding.signUpModel = viewmodel
        viewmodel.authInterface = this



    }

     override fun onstart() {

         toast("signUp start")
     }

     override fun onSucsess(user: User) {

         toast(user.username+" SignUp")
     }

     override fun onFailur(msg: String) {

         toast("Sign failed")
     }
 }