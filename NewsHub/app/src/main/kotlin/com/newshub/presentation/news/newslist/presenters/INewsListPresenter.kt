package com.newshub.presentation.news.newslist.presenters

import com.newshub.presentation.common.presenters.IBasePresenter
import com.newshub.presentation.news.newslist.views.INewsListView

/**
 * Interface that every NewsListPresenter should implement. It contains methods needed to react to user interactions.
 */
interface INewsListPresenter : IBasePresenter<INewsListView> {

    /**
     * Load the news list for the user's subscriptions.
     */
    fun loadNewsList()

}