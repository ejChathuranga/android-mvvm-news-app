package com.github.ejchathuranga.newsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.github.ejchathuranga.newsapp.data.adapters.BreakingNewsAdapter
import com.github.ejchathuranga.newsapp.data.adapters.TopNewsAdapter
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.data.viewmodel.SearchHomeViewModel
import com.github.ejchathuranga.newsapp.databinding.FragmentSearchHomeBinding

class SearchHomeFragment : Fragment() {

    lateinit var binding: FragmentSearchHomeBinding
    lateinit var viewModel: SearchHomeViewModel

    lateinit var breakingNewsAdapter: BreakingNewsAdapter
    lateinit var topNewsAdapter: TopNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SearchHomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.setSearchString(requireArguments().getString("searchText")!!)

        initObservers()
        initEnv()
    }


    private fun initObservers() {

        viewModel.getTopNews().observe(viewLifecycleOwner) {
            if (it.success) {
                topNewsAdapter.setData(it.data as ArrayList<Article>)
            } else {
                Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initEnv() {

        topNewsAdapter = TopNewsAdapter()
        binding.rvSearchResult.adapter = topNewsAdapter
        viewModel.search()

    }

    public companion object {
        @JvmStatic
        public fun newInstance() = SearchHomeFragment()
    }

}