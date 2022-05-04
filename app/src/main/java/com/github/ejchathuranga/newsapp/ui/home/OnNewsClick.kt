package com.github.ejchathuranga.newsapp.ui.home

import com.github.ejchathuranga.newsapp.data.model.api.Article

interface OnNewsClick {
    fun onCLick(article: Article)
}