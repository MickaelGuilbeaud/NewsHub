package com.newshub.presentation.common.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.newshub.presentation.common.NewsHubApplication;
import com.newshub.presentation.common.dependencyinjection.components.ApplicationComponent;
import com.newshub.presentation.common.dependencyinjection.modules.ActivityModule;

/**
 * Created by mickaelg on 27/01/2016.
 */
public class BaseActivity extends AppCompatActivity {

    // region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Dependency injection
        this.getApplicationComponent().inject(this);
    }

    // endregion


    // region Dependency injection

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    public ApplicationComponent getApplicationComponent() {
        return ((NewsHubApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    // endregion

}
