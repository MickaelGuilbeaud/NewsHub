package com.newshub.domain.news.interactors

import com.newshub.domain.common.executors.IPostExecutionThread
import com.newshub.domain.common.executors.IThreadExecutor
import com.newshub.domain.common.interactors.UseCase
import com.newshub.domain.news.models.News
import rx.Observable
import javax.inject.Inject

/**
 * Created by mickaelg on 23/02/2016.
 */
class GetNewsListInteractor
@Inject
constructor(threadExecutor: IThreadExecutor, postExecutionThread: IPostExecutionThread) :
        UseCase(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(): Observable<Any> {
        val newsList = arrayListOf<News>()
        for (i in 0..19) {
            newsList.add(News("Architecting Android... The clean way?", "The purpose of it is to show you a little approach I had in mind in the last few months plus all the stuff I have learnt from investigating and implementing it."))
        }
        return Observable.just(newsList)
    }

}