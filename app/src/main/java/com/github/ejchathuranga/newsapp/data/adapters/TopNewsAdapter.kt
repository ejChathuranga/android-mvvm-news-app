package com.github.ejchathuranga.newsapp.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ejchathuranga.newsapp.data.model.api.Article
import com.github.ejchathuranga.newsapp.databinding.TopNewsHolderBinding
import com.github.ejchathuranga.newsapp.ui.home.OnNewsClick
import com.github.ejchathuranga.newsapp.ui.home.TopNewsViewHolder

class TopNewsAdapter() : RecyclerView.Adapter<TopNewsViewHolder>() {
    private var dataList = ArrayList<Article>()
    private lateinit var callback: OnNewsClick

    fun setCallback(cb: OnNewsClick) {
        this.callback = cb
    }

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
        val article = dataList[position]
        holderTop.bind(article)
        holderTop.itemView.setOnClickListener {
            callback.onCLick(article)
        }
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

}