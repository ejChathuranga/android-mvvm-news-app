package com.github.ejchathuranga.newsapp.data.repositories

import com.github.ejchathuranga.newsapp.data.model.api.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsEndpoints {
    @GET(value = "v2/top-headlines?country=us&apiKey=" + RetroInstance.API_KEY)
    fun getNewsByCountry(): Call<MainResponse>

    @GET(value = "v2/everything?q=bitcoin&apiKey=" + RetroInstance.API_KEY)
    fun getTopNews(): Call<MainResponse>
}