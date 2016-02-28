package com.newshub.presentation.news.newslist.views.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.newshub.R
import com.newshub.presentation.common.decorations.VerticalSpacingDecoration
import com.newshub.presentation.common.views.BaseActivity
import com.newshub.presentation.common.views.BaseFragment
import com.newshub.presentation.news.common.dependencyinjection.DaggerNewsComponent
import com.newshub.presentation.news.common.models.NewsModel
import com.newshub.presentation.news.newslist.adapters.NewsAdapter
import com.newshub.presentation.news.newslist.presenters.INewsListPresenter
import com.newshub.presentation.news.newslist.views.INewsListView
import kotlinx.android.synthetic.main.fragment_news_list.*
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by mickaelg on 18/02/2016.
 */
class NewsListFragment : BaseFragment(), INewsListView, Toolbar.OnMenuItemClickListener {

    // region Properties

    @Inject
    lateinit var newsListPresenter: INewsListPresenter

    /**
     * Adapter displaying a list of news.
     */
    private lateinit var newsAdapter: NewsAdapter
    /**
     * List of news displayed in the view.
     */
    private val newsList = ArrayList<NewsModel>()

    // endregion


    // region Companion and Constructors

    companion object {
        val TAG = NewsListFragment::class.java.simpleName

        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }

    // endregion


    // region Lifecycle

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
        initDependencyInjection();
    }

    // endregion


    // region Initialization

    private fun initDependencyInjection() {
        // Init and perform dependency injection
        val baseActivity = activity as BaseActivity
        val productComponent = DaggerNewsComponent.builder()
                .applicationComponent(baseActivity.getApplicationComponent())
                .activityModule(baseActivity.getActivityModule())
                .build()
        productComponent.inject(this)

        newsListPresenter.setView(this)
        newsListPresenter.loadNewsList()
    }

    private fun initUI() {
        initToolbar()

        // Init the RecyclerView
        val llManager = LinearLayoutManager(activity)
        llManager.orientation = LinearLayoutManager.VERTICAL
        rvNewsList.layoutManager = llManager
        val spacingDecoration = VerticalSpacingDecoration(resources.getDimensionPixelSize(R.dimen.space_card_between))
        rvNewsList.addItemDecoration(spacingDecoration)

        // Set the adapter
        newsAdapter = NewsAdapter(activity, R.layout.listitem_news, newsList)
        rvNewsList.adapter = newsAdapter
    }

    // endregion


    // region Toolbar

    private fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_fragment_news_list)
        toolbar.setOnMenuItemClickListener(this)
        toolbar.title = getString(R.string.app_name)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_customize -> {
                // TODO: Show customize view
                Timber.d("Customize menu item clicked")
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    // endregion


    // region INewsListView implementation

    override fun showNewsList(newsListToShow: List<NewsModel>) {
        newsList.clear()
        newsList.addAll(newsListToShow)
        newsAdapter.notifyDataSetChanged()
    }

    // endregion

}