package com.newshub.presentation.news.common.dependencyinjection

import com.newshub.presentation.common.dependencyinjection.PerActivity
import com.newshub.presentation.common.dependencyinjection.components.ActivityComponent
import com.newshub.presentation.common.dependencyinjection.components.ApplicationComponent
import com.newshub.presentation.common.dependencyinjection.modules.ActivityModule
import com.newshub.presentation.news.newslist.views.fragments.NewsListFragment
import dagger.Component

/**
 * Component used to inject News related objects (NewsList, NewsDetails...).
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class, NewsModule::class))
interface NewsComponent : ActivityComponent {

    fun inject(newsListFragment: NewsListFragment)

}