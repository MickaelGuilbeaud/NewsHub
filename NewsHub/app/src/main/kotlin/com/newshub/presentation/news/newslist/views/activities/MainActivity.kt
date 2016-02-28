package com.newshub.presentation.news.newslist.views.activities

import android.os.Bundle
import com.newshub.R
import com.newshub.presentation.common.views.BaseActivity
import com.newshub.presentation.news.newslist.views.fragments.NewsListFragment

/**
 * Created by mickaelg on 11/02/2016.
 */
class MainActivity : BaseActivity() {

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        supportFragmentManager.beginTransaction()
                .replace(R.id.flFragmentContainer, NewsListFragment.newInstance(), NewsListFragment.TAG)
                .commit()
    }

    // endregion

}