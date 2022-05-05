package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

open class SuperViewModel:ViewModel() {

    private var error = MutableLiveData<ValidateResponse>()
    lateinit var job: Job

    // use global exception handler provide by Coroutine
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun onError(error: String) {
        this.error.postValue(ValidateResponse(false, error))
    }

    fun getError(): MutableLiveData<ValidateResponse> {
        return this.error
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}