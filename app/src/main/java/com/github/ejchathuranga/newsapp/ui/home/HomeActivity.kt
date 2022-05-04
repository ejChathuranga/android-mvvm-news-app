package com.github.ejchathuranga.newsapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.R
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.data.viewmodel.HomeViewModel
import com.github.ejchathuranga.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var breakingNewsAdapter: BreakingNewsAdapter
    lateinit var topNewsAdapter: TopNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObservers()
        initEnv()

    }


    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

    private fun initObservers() {

        viewModel.getBreakingNews().observe(this) {
            if (it.success) {
                breakingNewsAdapter.setData(it.data as ArrayList<Article>)
            } else {
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getTopNews().observe(this){
            if (it.success) {
                topNewsAdapter.setData(it.data as ArrayList<Article>)
            } else {
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initEnv() {
        breakingNewsAdapter = BreakingNewsAdapter()
        binding.rvBreakingNews.adapter = breakingNewsAdapter
        viewModel.searchBreakingNews()

        topNewsAdapter = TopNewsAdapter()
        binding.rvTopNews.adapter = topNewsAdapter
        viewModel.searchTopNews()

    }

}