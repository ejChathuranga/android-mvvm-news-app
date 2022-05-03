package com.github.ejchathuranga.newsapp.data.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.LoginUser
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse

class LoginViewModel : ViewModel() {

    private val username = MutableLiveData<String>()
    private val password = MutableLiveData<String>()
    private val loginSuccess = MutableLiveData<ValidateResponse>()
    private val user: LoginUser = LoginUser("", "")

    fun getUsername(): MutableLiveData<String> {
        return this.username
    }

    fun getPassword(): MutableLiveData<String> {
        return this.password
    }

    fun getLoginSuccess(): MutableLiveData<ValidateResponse> {
        return this.loginSuccess;
    }

    fun login(view: View) {
        this.loginSuccess.postValue(user.validate(username.value, password.value))
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}