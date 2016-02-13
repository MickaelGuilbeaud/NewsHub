package com.newshub.presentation.common.dependencyinjection.modules

import android.app.Activity
import com.newshub.presentation.common.dependencyinjection.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by mickaelg on 07/02/2016.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    fun activity(): Activity {
        return activity
    }

}