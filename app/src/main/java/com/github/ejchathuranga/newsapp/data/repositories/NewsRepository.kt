package com.github.ejchathuranga.newsapp.data.repositories

import androidx.lifecycle.MutableLiveData
import com.github.ejchathuranga.newsapp.data.model.ValidateResponse
import com.github.ejchathuranga.newsapp.data.model.api.MainResponse
import com.github.ejchathuranga.newsapp.domain.ResponseValidator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    private val service = RetroInstance.getRetroInstance()

    fun getNewsByCountry(searchByCountry: MutableLiveData<ValidateResponse>) {
        val call: Call<MainResponse> = service.getNewsByCountry()

        call.enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                searchByCountry.postValue(ResponseValidator().validateResponse(response))
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                searchByCountry.postValue(ValidateResponse(false, t.localizedMessage))
                t.printStackTrace()
            }

        })
    }
}