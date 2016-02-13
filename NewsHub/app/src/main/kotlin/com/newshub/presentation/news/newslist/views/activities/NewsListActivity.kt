package com.newshub.presentation.news.newslist.views.activities

import android.os.Bundle
import android.os.PersistableBundle
import com.newshub.R
import com.newshub.presentation.common.views.BaseActivity

/**
 * Created by mickaelg on 11/02/2016.
 */
class NewsListActivity : BaseActivity() {

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_news_list)
    }

    // endregion

}