package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository

class HomeViewModel:ViewModel() {
    private val repository =  NewsRepository()
    private var searchByCountry = MutableLiveData<ValidateResponse>()

    fun getSearchByCountry(): MutableLiveData<ValidateResponse>{
        return this.searchByCountry
    }

    fun searchByCountry(){
        repository.getNewsByCountry(searchByCountry)
    }

}