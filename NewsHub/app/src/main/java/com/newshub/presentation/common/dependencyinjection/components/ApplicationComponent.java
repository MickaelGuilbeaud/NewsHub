package com.newshub.presentation.common.dependencyinjection.components;

import com.newshub.domain.common.executors.IPostExecutionThread;
import com.newshub.domain.common.executors.IThreadExecutor;
import com.newshub.presentation.common.NewsHubApplication;
import com.newshub.presentation.common.dependencyinjection.modules.ApplicationModule;
import com.newshub.presentation.common.views.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity application);

    // Exposed to sub-graphs

    NewsHubApplication application();

    IThreadExecutor threadExecutor();

    IPostExecutionThread postExecutionThread();

}