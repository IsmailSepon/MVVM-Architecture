package com.sepon.mvvmarchitecture.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sepon.mvvmarchitecture.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
   private val repository: UserRepository
)   : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewmodel(repository) as T
    }
}