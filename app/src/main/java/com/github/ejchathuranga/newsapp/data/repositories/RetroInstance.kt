package com.github.ejchathuranga.newsapp.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {
    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "https://newsapi.org/"

        private var retroService: NewsEndpoints? = null

        fun getRetroInstance(): NewsEndpoints {

            if (retroService == null) {
                val retro = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

                retroService = retro.create(NewsEndpoints::class.java)
            }
            return retroService !!;
        }
    }
}