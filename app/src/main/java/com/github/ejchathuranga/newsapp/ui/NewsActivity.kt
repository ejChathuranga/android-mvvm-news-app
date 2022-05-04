package com.github.ejchathuranga.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.ejchathuranga.newsapp.R
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.ActivityNewsBinding
import com.squareup.picasso.Picasso

class NewsActivity : AppCompatActivity() {
    private val TAG = "NewsActivity"

    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBindings()

    }

    private fun initBindings() {
        val article:Article = intent.getSerializableExtra("article") as Article

        binding.ibNewsBack.setOnClickListener{
            finish()
        }

        binding.tvNewsAuthor.text = article.author
        binding.tvNewsContent.text = article.content
        binding.tvNewsTitle.text = article.title

        if (article.urlToImage.isNotEmpty()){
            Picasso.get()
                .load(article.urlToImage)
                .fit()
                .centerCrop()
                .into(binding.ivBanner)
        }

    }
}