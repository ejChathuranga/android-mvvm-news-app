package com.github.ejchathuranga.newsapp.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
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
        viewModel.getError().observe(this) {
            if (!it.success) {
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchView() {
        supportFragmentManager.commit {
            val bundle = bundleOf("searchText" to viewModel.getSearchText().value)
            setReorderingAllowed(true)

            replace(R.id.flHomeContainer, SearchHomeFragment::class.java, bundle)
            addToBackStack("searchHomeFragment")
        }
        binding.ivSearchIcon.setImageResource(R.drawable.ic_baseline_close_24)
    }

    private fun defaultView() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<DefaultHomeFragment>(R.id.flHomeContainer)
            addToBackStack("defaultHomeFragment")
        }
        binding.ivSearchIcon.setImageResource(R.drawable.ic_baseline_search_24)
        binding.etSearchText.setText("")
    }

    private fun initEnv() {
        defaultView()
        binding.ivSearchIcon.setOnClickListener {
            viewModel.searchNews()
        }
    }

}