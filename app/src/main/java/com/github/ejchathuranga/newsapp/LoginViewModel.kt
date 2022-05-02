package com.github.ejchathuranga.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    fun login() {
        this.loginSuccess.postValue(user.validate(username.value, password.value))
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}