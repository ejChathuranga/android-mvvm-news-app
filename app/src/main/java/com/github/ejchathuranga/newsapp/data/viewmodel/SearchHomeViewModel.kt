package com.github.ejchathuranga.newsapp.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.repositories.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchHomeViewModel() : SuperViewModel() {
    private val repository = NewsRepository()
    private var searchResult = MutableLiveData<ValidateResponse>()
    private lateinit var searchString: String

    fun getTopNews(): MutableLiveData<ValidateResponse> {
        return this.searchResult
    }

    fun setSearchString(text: String) {
        this.searchString = text
    }

    fun search() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            repository.searchNews(searchString, searchResult)
        }
    }
}