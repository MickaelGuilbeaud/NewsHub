package com.newshub.presentation.news.newslist.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.newshub.R
import com.newshub.presentation.news.common.models.NewsModel

/**
 * Created by mickaelg on 20/02/2016.
 */
class NewsAdapter(private val context: Context, private val layout: Int, private val newsList: List<NewsModel>)
        : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    // region RecyclerView.Adapter implementation

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val news = newsList[position]

        if (news.title != null) {
            holder?.tvTitle?.text = news.title
            holder?.tvTitle?.visibility = View.VISIBLE
        } else {
            holder?.tvTitle?.visibility = View.GONE
        }

        holder?.tvMessage?.text = news.message
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    // endregion


    // region ViewHolder

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle : TextView
        val tvMessage : TextView

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle) as TextView
            tvMessage = itemView.findViewById(R.id.tvMessage) as TextView
        }

    }

    // endregion

}