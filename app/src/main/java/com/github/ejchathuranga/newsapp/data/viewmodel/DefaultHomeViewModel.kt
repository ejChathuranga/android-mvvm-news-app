package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DefaultHomeViewModel : SuperViewModel(){
    private val repository = NewsRepository()
    private var breakingNews = MutableLiveData<ValidateResponse>()
    private var topNews = MutableLiveData<ValidateResponse>()

    fun getBreakingNews(): MutableLiveData<ValidateResponse> {
        return this.breakingNews
    }

    fun getTopNews(): MutableLiveData<ValidateResponse> {
        return this.topNews
    }

    fun searchBreakingNews() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            repository.getNewsByCountry(breakingNews)
        }
    }

    fun searchTopNews() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            repository.getTopNews(topNews)
        }
    }
}