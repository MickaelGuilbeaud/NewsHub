package com.newshub.presentation.common;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.newshub.BuildConfig;
import com.newshub.presentation.common.dependencyinjection.components.ApplicationComponent;
import com.newshub.presentation.common.dependencyinjection.components.DaggerApplicationComponent;
import com.newshub.presentation.common.dependencyinjection.modules.ApplicationModule;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by mickaelg on 27/01/2016.
 */
public class NewsHubApplication extends Application {

    // region Properties

    private static NewsHubApplication application;

    private ApplicationComponent applicationComponent;

    // endregion


    // region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        // First, set Application context
        application = this;

        // Init Crashlytics
        if (BuildConfig.REPORT_CRASHES) {
            Fabric.with(this, new Crashlytics());
        }

        // Inject Application Component
        initializeInjector();

        // Init Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    // endregion


    // region Getters and Setters

    public static NewsHubApplication getApplication() {
        return application;
    }

    // endregion


    // region Dependency Injection

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    // endregion

}
