package com.newshub.presentation.news.common.mappers

import com.newshub.domain.news.models.News
import com.newshub.presentation.common.mappers.BaseDataMapper
import com.newshub.presentation.news.common.models.NewsModel

/**
 * Created by mickaelg on 23/02/2016.
 */
class NewsModelDataMapper : BaseDataMapper<News, NewsModel>() {

    override fun createObject(sourceObject: News): NewsModel {
        return NewsModel(sourceObject.title, sourceObject.message)
    }

}