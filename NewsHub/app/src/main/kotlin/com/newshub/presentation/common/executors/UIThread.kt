package com.newshub.presentation.common.executors

import com.newshub.domain.common.executors.IPostExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mickaelg on 08/02/2016.
 */
@Singleton
class UIThread
@Inject
constructor(): IPostExecutionThread {

    override fun getScheduler(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }

}
