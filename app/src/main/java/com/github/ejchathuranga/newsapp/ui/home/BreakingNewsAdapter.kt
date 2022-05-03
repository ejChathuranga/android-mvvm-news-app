package com.github.ejchathuranga.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.BreakingNewsHolderBinding

class BreakingNewsAdapter() : RecyclerView.Adapter<BreakingNewsViewHolder>() {
    private var dataList = ArrayList<Article>()

    fun setData(dataList: ArrayList<Article>) {
        val oldSize = this.dataList.size
        this.dataList = dataList
        notifyItemRangeChanged(oldSize, dataList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BreakingNewsHolderBinding.inflate(inflater, parent, false)
        return BreakingNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holderBreaking: BreakingNewsViewHolder, position: Int) {
        holderBreaking.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }
}