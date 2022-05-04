package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository

class HomeViewModel:ViewModel() {
    private val repository =  NewsRepository()
    private var breakingNews = MutableLiveData<ValidateResponse>()
    private var topNews = MutableLiveData<ValidateResponse>()

    fun getBreakingNews(): MutableLiveData<ValidateResponse>{
        return this.breakingNews
    }

    fun getTopNews(): MutableLiveData<ValidateResponse>{
        return this.topNews
    }

    fun searchBreakingNews(){
        repository.getNewsByCountry(breakingNews)
    }

    fun searchTopNews(){
        repository.getTopNews(topNews)
    }

}