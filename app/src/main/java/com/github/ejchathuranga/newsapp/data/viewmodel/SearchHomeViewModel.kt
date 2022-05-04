package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository

class SearchHomeViewModel(): ViewModel() {
    private val repository =  NewsRepository()
    private var searchResult = MutableLiveData<ValidateResponse>()


    fun getTopNews(): MutableLiveData<ValidateResponse> {
        return this.searchResult
    }

    fun search(){
        repository.getTopNews(searchResult)
    }
}