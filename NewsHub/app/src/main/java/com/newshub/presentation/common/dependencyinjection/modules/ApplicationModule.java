package com.newshub.presentation.common.dependencyinjection.modules;

import com.newshub.data.common.executors.JobExecutor;
import com.newshub.domain.common.executors.IPostExecutionThread;
import com.newshub.domain.common.executors.IThreadExecutor;
import com.newshub.presentation.common.NewsHubApplication;
import com.newshub.presentation.common.executors.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final NewsHubApplication application;

    public ApplicationModule(NewsHubApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    NewsHubApplication provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    IThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    IPostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
