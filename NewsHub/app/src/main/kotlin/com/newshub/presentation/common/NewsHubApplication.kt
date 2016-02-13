package com.newshub.presentation.common

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.newshub.BuildConfig
import com.newshub.presentation.common.dependencyinjection.components.ApplicationComponent
import com.newshub.presentation.common.dependencyinjection.components.DaggerApplicationComponent
import com.newshub.presentation.common.dependencyinjection.modules.ApplicationModule
import io.fabric.sdk.android.Fabric
import timber.log.Timber

/**
 * Created by mickaelg on 08/02/2016.
 */
class NewsHubApplication: Application() {

    // region Properties

    companion object {
        lateinit var application: NewsHubApplication
    }

    lateinit var applicationComponent: ApplicationComponent

    // endregion


    // region Lifecycle

    override fun onCreate() {
        super.onCreate()

        // First, set Application context
        NewsHubApplication.application = this

        // Init Crashlytics
        if (BuildConfig.REPORT_CRASHES) {
            Fabric.with(this, Crashlytics())
        }

        // Inject Application Component
        initializeInjector()

        // Init Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    // endregion


    // region Dependency Injection

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    // endregion

}