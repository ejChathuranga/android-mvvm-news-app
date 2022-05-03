package com.github.ejchathuranga.newsapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.BreakingNewsHolderBinding
import com.squareup.picasso.Picasso

class BreakingNewsViewHolder(var binding: BreakingNewsHolderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article){
        binding.tvBreakingNewsAuthor.text = article.author
        binding.tvBreakingNewsDescription.text = article.description
        binding.tvBreakingNewsTitle.text = article.title

        Picasso.get()
            .load(article.urlToImage)
            .fit()
            .centerCrop()
            .into(binding.ivBreakingNewsItemBG)
    }
}