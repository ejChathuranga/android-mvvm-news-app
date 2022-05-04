package com.github.ejchathuranga.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.BreakingNewsHolderBinding
import com.github.ejchathuranga.newsapp.databinding.TopNewsHolderBinding

class TopNewsAdapter() : RecyclerView.Adapter<TopNewsViewHolder>() {
    private var dataList = ArrayList<Article>()

    fun setData(dataList: ArrayList<Article>) {
        val oldSize = this.dataList.size
        this.dataList = dataList
        notifyItemRangeChanged(oldSize, dataList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopNewsHolderBinding.inflate(inflater, parent, false)
        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holderTop: TopNewsViewHolder, position: Int) {
        holderTop.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }
}