package com.newshub.presentation.common.dependencyinjection.components

import android.app.Activity
import com.newshub.presentation.common.dependencyinjection.PerActivity
import com.newshub.presentation.common.dependencyinjection.modules.ActivityModule
import dagger.Component

/**
 * Created by mickaelg on 07/02/2016.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity

}
