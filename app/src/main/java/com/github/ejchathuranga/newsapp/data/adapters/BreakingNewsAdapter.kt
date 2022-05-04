package com.github.ejchathuranga.newsapp.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.BreakingNewsHolderBinding
import com.github.ejchathuranga.newsapp.ui.home.BreakingNewsViewHolder
import com.github.ejchathuranga.newsapp.ui.home.OnNewsClick

class BreakingNewsAdapter() : RecyclerView.Adapter<BreakingNewsViewHolder>() {
    private var dataList = ArrayList<Article>()
    private lateinit var callback: OnNewsClick

    fun setData(dataList: ArrayList<Article>) {
        val oldSize = this.dataList.size
        this.dataList = dataList
        notifyItemRangeChanged(oldSize, dataList.size)
    }

    fun setCallback(cb: OnNewsClick) {
        this.callback = cb
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BreakingNewsHolderBinding.inflate(inflater, parent, false)
        return BreakingNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holderBreaking: BreakingNewsViewHolder, position: Int) {
        val article = dataList[position]
        holderBreaking.bind(article)
        holderBreaking.itemView.setOnClickListener {
            callback.onCLick(article)
        }
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }
}