package com.github.ejchathuranga.newsapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.BreakingNewsHolderBinding
import com.github.ejchathuranga.newsapp.databinding.TopNewsHolderBinding
import com.squareup.picasso.Picasso

class TopNewsViewHolder(var binding: TopNewsHolderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article){
        binding.tvTopNewAuthor.text = article.author
        binding.tvTopNewsDate.text = article.publishedAt
        binding.tvTopNewsTitle.text = article.title

        Picasso.get()
            .load(article.urlToImage)
            .fit()
            .centerCrop()
            .into(binding.ivTopNewsItemBG)
    }
}