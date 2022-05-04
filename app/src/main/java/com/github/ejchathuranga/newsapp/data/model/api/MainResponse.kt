package com.github.ejchathuranga.newsapp.data.model.api

import java.io.Serializable

data class MainResponse(
    var status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
) {
}

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
):Serializable {}