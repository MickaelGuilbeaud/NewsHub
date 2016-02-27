package com.newshub.presentation.news.newslist.views.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.newshub.R
import com.newshub.presentation.common.views.BaseActivity
import com.newshub.presentation.news.newslist.views.fragments.NewsListFragment
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by mickaelg on 11/02/2016.
 */
class NewsListActivity : BaseActivity() {

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setSupportActionBar(mToolbar);

        supportFragmentManager.beginTransaction()
                .replace(R.id.flFragmentContainer, NewsListFragment.newInstance(), NewsListFragment.TAG)
                .commit()
    }

    // endregion


    // region Menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fragment_news_list, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_customize -> {
                // TODO: Show customize view
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    // endregion

}