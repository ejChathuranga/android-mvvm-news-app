package com.github.ejchathuranga.newsapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.R
import com.github.ejchathuranga.newsapp.data.adapters.BreakingNewsAdapter
import com.github.ejchathuranga.newsapp.data.adapters.TopNewsAdapter
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.data.viewmodel.DefaultHomeViewModel
import com.github.ejchathuranga.newsapp.data.viewmodel.HomeViewModel
import com.github.ejchathuranga.newsapp.databinding.FragmentDefaultHomeBinding
import com.github.ejchathuranga.newsapp.ui.NewsActivity

class DefaultHomeFragment : Fragment(), OnNewsClick {

    lateinit var binding: FragmentDefaultHomeBinding
    lateinit var viewModel: DefaultHomeViewModel

    lateinit var breakingNewsAdapter: BreakingNewsAdapter
    lateinit var topNewsAdapter: TopNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDefaultHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DefaultHomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        initObservers()
        initEnv()
    }


    private fun initObservers() {

        viewModel.getBreakingNews().observe(viewLifecycleOwner) {
            if (it.success) {
                breakingNewsAdapter.setData(it.data as ArrayList<Article>)
            } else {
                Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getTopNews().observe(viewLifecycleOwner) {
            if (it.success) {
                topNewsAdapter.setData(it.data as ArrayList<Article>)
            } else {
                Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getError().observe(viewLifecycleOwner) {
            if (!it.success) {
                Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initEnv() {
        breakingNewsAdapter = BreakingNewsAdapter()
        breakingNewsAdapter.setCallback(this)
        binding.rvBreakingNews.adapter = breakingNewsAdapter
        viewModel.searchBreakingNews()

        topNewsAdapter = TopNewsAdapter()
        topNewsAdapter.setCallback(this)
        binding.rvTopNews.adapter = topNewsAdapter
        viewModel.searchTopNews()

    }

    public companion object {
        @JvmStatic
        public fun newInstance() = DefaultHomeFragment()
    }

    override fun onCLick(article: Article) {
        val intent = Intent(context, NewsActivity::class.java)

        intent.putExtra("article", article)

        startActivity(intent)
    }

}