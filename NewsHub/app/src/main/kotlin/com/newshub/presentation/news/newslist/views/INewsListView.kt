package com.newshub.presentation.news.newslist.views

import com.newshub.presentation.news.common.models.NewsModel

/**
 * Interface containing methods to manipulate a NewsListView. A NewsListView shows a list of news, allowing the user to
 * see the details of a news or update his subscriptions.
 */
interface INewsListView {

    /**
     * Show a list of news.
     */
    fun showNewsList(newsListToShow: List<NewsModel>)

}