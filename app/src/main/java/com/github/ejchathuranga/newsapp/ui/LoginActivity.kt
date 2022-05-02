package com.github.ejchathuranga.newsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.data.viewmodel.LoginViewModel
import com.github.ejchathuranga.newsapp.R
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

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }


    private fun initObservers() {
        viewModel.getLoginSuccess().observe(this) {
            if (it.success)
                startActivity(Intent(this, HomeActivity::class.java))
            else
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}