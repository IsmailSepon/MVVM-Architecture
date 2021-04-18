 package com.sepon.mvvmarchitecture.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sepon.mvvmarchitecture.R
import com.sepon.mvvmarchitecture.data.entity.User
import com.sepon.mvvmarchitecture.databinding.ActivityMainBinding
import com.sepon.mvvmarchitecture.ui.auth.AuthInterface
import com.sepon.mvvmarchitecture.ui.auth.AuthViewModelFactory
import com.sepon.mvvmarchitecture.ui.auth.AuthViewmodel
import com.sepon.mvvmarchitecture.ui.profile.ProfileActivity
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

 class LoginActivity : AppCompatActivity() , AuthInterface, KodeinAware{


     override val kodein by kodein()
     private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//remove it after implemetn KODEIN & now get it from KODIN
//        val netIntercepter = NetConnectionIntercepter(this)
//        val api = APIServices(netIntercepter)
//        val db = AppDatabase(this)
//        val repository = UserRepository(api, db)
//        val factory = AuthViewModelFactory(repository)



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

         Intent(this, ProfileActivity::class.java).also {
             startActivity(it)
         }

        toast("${user.username} is logged IN ")
     }

     override fun onFailur(msg: String) {

         toast(msg)
         logError("login", msg)
     }
 }