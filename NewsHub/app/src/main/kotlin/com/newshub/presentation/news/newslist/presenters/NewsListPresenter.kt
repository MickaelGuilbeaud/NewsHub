package com.newshub.presentation.news.newslist.presenters

import com.newshub.domain.common.interactors.DefaultSubscriber
import com.newshub.domain.news.interactors.GetNewsListInteractor
import com.newshub.domain.news.models.News
import com.newshub.presentation.common.dependencyinjection.PerActivity
import com.newshub.presentation.news.common.mappers.NewsModelDataMapper
import com.newshub.presentation.news.common.models.NewsModel
import com.newshub.presentation.news.newslist.views.INewsListView
import javax.inject.Inject

/**
 * Created by mickaelg on 18/02/2016.
 */
@PerActivity
class NewsListPresenter
@Inject
constructor(private val getNewsListInteractor: GetNewsListInteractor) : INewsListPresenter {

    // region Properties

    private lateinit var newsListView: INewsListView

    private val newsModelDataMapper = NewsModelDataMapper()

    // endregion


    // region INewsListPresenter implementation

    override fun loadNewsList() {
        getNewsListInteractor.execute(NewsListSubscriber())
    }

    override fun setView(view: INewsListView) {
        newsListView = view
    }

    override fun destroy() {
        getNewsListInteractor.unsubscribe()
    }

    // endregion


    // region Business methods

    private fun showNewsList(newsList: List<NewsModel>) {
        newsListView.showNewsList(newsList)
    }

    // endregion


    // region Subscribers

    private inner class NewsListSubscriber : DefaultSubscriber<Any>() {

        override fun onCompleted() {
            // TODO : Hide loader
        }

        override fun onError(e: Throwable) {
            // TODO : Hide loader and show error message
        }

        override fun onNext(t: Any?) {
            val newsList = t as List<News>
            val newsModelList = newsModelDataMapper.transform(newsList)
            showNewsList(newsModelList)
        }
    }

    // endregion

}