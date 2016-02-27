package com.newshub.presentation.news.common.dependencyinjection

import com.newshub.presentation.common.dependencyinjection.PerActivity
import com.newshub.presentation.news.newslist.presenters.INewsListPresenter
import com.newshub.presentation.news.newslist.presenters.NewsListPresenter
import dagger.Module
import dagger.Provides

/**
 * Module providing implementations related to news (NewsList, NewsDetails...).
 */
@Module
class NewsModule {

    @Provides
    @PerActivity
    fun provideNewsListPresenter(newsListPresenter: NewsListPresenter): INewsListPresenter {
        return newsListPresenter
    }

}