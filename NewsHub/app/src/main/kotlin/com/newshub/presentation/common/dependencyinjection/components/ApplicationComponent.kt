package com.newshub.presentation.common.dependencyinjection.components

import com.newshub.domain.common.executors.IPostExecutionThread
import com.newshub.domain.common.executors.IThreadExecutor
import com.newshub.presentation.common.NewsHubApplication
import com.newshub.presentation.common.dependencyinjection.modules.ApplicationModule
import com.newshub.presentation.common.views.BaseActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mickaelg on 07/02/2016.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(baseActivity: BaseActivity)

    fun application(): NewsHubApplication

    fun threadExecutor(): IThreadExecutor

    fun postExecutionThread(): IPostExecutionThread

}