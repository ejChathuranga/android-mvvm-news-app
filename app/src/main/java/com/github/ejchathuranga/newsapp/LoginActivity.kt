package com.github.ejchathuranga.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObservers()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }
    }


    private fun initObservers() {

        viewModel.getErrorMsg().observe(this) {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}