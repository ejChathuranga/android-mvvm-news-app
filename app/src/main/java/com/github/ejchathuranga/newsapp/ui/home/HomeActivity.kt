package com.github.ejchathuranga.newsapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
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

    }

    private fun initEnv() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<DefaultHomeFragment>(R.id.flHomeContainer)
        }

    }

}