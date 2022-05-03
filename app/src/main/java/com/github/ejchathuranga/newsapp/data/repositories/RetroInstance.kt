package com.github.ejchathuranga.newsapp.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {
    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "65af967afbb64c51acfc57e22efea7cc"

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