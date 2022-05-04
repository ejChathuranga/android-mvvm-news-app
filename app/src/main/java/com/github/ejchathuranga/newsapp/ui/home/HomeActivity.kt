package com.github.ejchathuranga.newsapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.R
import com.github.ejchathuranga.newsapp.data.viewmodel.HomeViewModel
import com.github.ejchathuranga.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel

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
        viewModel.getIsSearching().observe(this) {
            if (it)
                searchView()
            else
                defaultView()
        }
        viewModel.getSearchResult().observe(this) {
        }
    }

    private fun searchView(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<SearchHomeFragment>(R.id.flHomeContainer)
            addToBackStack("searchHomeFragment")
        }
        binding.ivSearchIcon.setImageResource(R.drawable.ic_baseline_close_24)
    }

    private fun defaultView(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<DefaultHomeFragment>(R.id.flHomeContainer)
            addToBackStack("defaultHomeFragment")
        }
        binding.ivSearchIcon.setImageResource(R.drawable.ic_baseline_search_24)
    }

    private fun initEnv() {
        defaultView()
        binding.ivSearchIcon.setOnClickListener {
            viewModel.searchNews()
        }
    }

}