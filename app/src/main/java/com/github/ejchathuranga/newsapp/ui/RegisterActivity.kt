package com.github.ejchathuranga.newsapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.R
import com.github.ejchathuranga.newsapp.data.viewmodel.RegisterViewModel
import com.github.ejchathuranga.newsapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding;
    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViewModel()
        initObservers()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }


    private fun initObservers() {
        viewModel.getRegistrationStatus().observe(this){
            if (it.success)
                startActivity(Intent(this, HomeActivity::class.java))
            else
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
        }
    }

}