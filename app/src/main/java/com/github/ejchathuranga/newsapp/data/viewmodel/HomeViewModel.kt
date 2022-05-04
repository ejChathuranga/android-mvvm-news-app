package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository

class HomeViewModel:ViewModel() {
    private val repository =  NewsRepository()
    private var breakingNews = MutableLiveData<ValidateResponse>()
    private var searchResult = MutableLiveData<ValidateResponse>()
    private var searchText = MutableLiveData<String>()
    private val isSearching = MutableLiveData<Boolean>()

    init {
        isSearching.value = false
    }

    fun getIsSearching(): MutableLiveData<Boolean> {
        return this.isSearching
    }

    fun getSearchText():MutableLiveData<String>{
        return  this.searchText;
    }

    fun searchNews(){
        changeIcon()
    }

    fun changeIcon(){
        this.isSearching.value = isSearching.value != true
        isSearching.postValue(isSearching.value)
    }

    fun getSearchResult(): MutableLiveData<ValidateResponse>{
        return this.searchResult
    }

}