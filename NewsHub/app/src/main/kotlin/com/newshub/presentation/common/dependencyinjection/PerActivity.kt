package com.newshub.presentation.common.dependencyinjection

import java.lang.annotation.Retention
import javax.inject.Scope

import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * Created by mickaelg on 07/02/2016.
 */
@Scope
@Retention(RUNTIME)
annotation class PerActivity