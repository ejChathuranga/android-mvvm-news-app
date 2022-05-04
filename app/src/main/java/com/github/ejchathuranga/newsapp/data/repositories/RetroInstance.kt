package com.github.ejchathuranga.newsapp.data.repositories

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {
    companion object {
        private const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "65af967afbb64c51acfc57e22efea7cc"

        private var retroService: NewsEndpoints? = null

        fun getRetroInstance(): NewsEndpoints {

            val client = OkHttpClient()
                .newBuilder()
                .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            if (retroService == null) {
                val retro = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

                retroService = retro.create(NewsEndpoints::class.java)
            }
            return retroService !!;
        }
    }
}