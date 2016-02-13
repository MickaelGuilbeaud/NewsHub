package com.newshub.presentation.common.dependencyinjection.modules

import com.newshub.data.common.executors.JobExecutor
import com.newshub.domain.common.executors.IPostExecutionThread
import com.newshub.domain.common.executors.IThreadExecutor
import com.newshub.presentation.common.NewsHubApplication
import com.newshub.presentation.common.executors.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mickaelg on 07/02/2016.
 */
@Module
class ApplicationModule(private val application: NewsHubApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): NewsHubApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): IThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): IPostExecutionThread {
        return uiThread
    }

}