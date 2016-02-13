package com.newshub.presentation.common.views

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.newshub.presentation.common.NewsHubApplication
import com.newshub.presentation.common.dependencyinjection.components.ApplicationComponent
import com.newshub.presentation.common.dependencyinjection.modules.ActivityModule

/**
 * Created by mickaelg on 11/02/2016.
 */
open class BaseActivity : AppCompatActivity() {

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        // Dependency injection
        this.getApplicationComponent().inject(this)
    }

    // endregion


    // region Dependency injection

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return [ApplicationComponent]
     */
    fun getApplicationComponent(): ApplicationComponent {
        return (application as NewsHubApplication).applicationComponent
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return [ActivityModule]
     */
    fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    // endregion

}