package com.github.ejchathuranga.newsapp

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(), Observable {
    @Bindable
    val username = MutableLiveData<String>()

    @Bindable
    val password = MutableLiveData<String>()

    private val user: LoginUser
    private var errorMsg: MutableLiveData<String> = MutableLiveData();

    init {
        user = LoginUser("", "")
    }

    fun getErrorMsg(): MutableLiveData<String> {
        return this.errorMsg;
    }

    fun login() {
        val validateResponse: ValidateResponse = user.validate(username.value, password.value)

        if (validateResponse.success) {
            //TODO :: go to dashboard
        } else {
            errorMsg.postValue(validateResponse.msg)
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("Not yet implemented")
    }

}