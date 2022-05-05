package com.github.ejchathuranga.newsapp.data.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.User
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.domain.ValidateUserUserCase

class RegisterViewModel : SuperViewModel() {
    private val uname = MutableLiveData<String>()
    private val pass = MutableLiveData<String>()
    private val passConfirm = MutableLiveData<String>()
    private val email = MutableLiveData<String>()
    private val age = MutableLiveData<String>()
    private val registerStatus = MutableLiveData<ValidateResponse>()

    private val user = User(0)

    fun getUname(): MutableLiveData<String> {
        return this.uname
    }

    fun getPass(): MutableLiveData<String> {
        return this.pass
    }

    fun getPassC(): MutableLiveData<String> {
        return this.passConfirm
    }

    fun getEmail(): MutableLiveData<String> {
        return this.email
    }

    fun getAge(): MutableLiveData<String> {
        return this.age
    }

    fun getRegistrationStatus(): MutableLiveData<ValidateResponse> {
        return this.registerStatus;
    }

    fun register(view: View) {
        this.user.username = getUname().value
        this.user.email = getEmail().value
        this.user.age = getAge().value
        this.user.pass = getPass().value
        this.user.passC = getPassC().value

        this.registerStatus.postValue(ValidateUserUserCase().validateUser(user))
    }

    companion object {
        private const val TAG = "RegisterViewModel"
    }


}