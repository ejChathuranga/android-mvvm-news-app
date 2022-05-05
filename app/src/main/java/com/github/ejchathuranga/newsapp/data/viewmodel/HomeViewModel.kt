package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository

class HomeViewModel : SuperViewModel() {
    private var searchText = MutableLiveData<String>()
    private val isSearching = MutableLiveData<Boolean>()

    init {
        isSearching.value = false
    }

    fun getIsSearching(): MutableLiveData<Boolean> {
        return this.isSearching
    }

    fun getSearchText(): MutableLiveData<String> {
        return this.searchText;
    }

    fun searchNews() {
        if (searchText.value != null && searchText.value!!.isNotEmpty())
            changeIcon()
    }

    private fun changeIcon() {
        this.isSearching.value = isSearching.value != true
        isSearching.postValue(isSearching.value)
    }


}