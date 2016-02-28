package com.newshub.domain.common.interactors

import com.newshub.domain.common.executors.IPostExecutionThread
import com.newshub.domain.common.executors.IThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture). This interface represents a execution unit
 * for different use cases (this means any use case in the application should implement this contract).
 * By convention each UseCase implementation will return the result using a [Subscriber] that will execute its
 * job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase (
        private val threadExecutor: IThreadExecutor,
        private val postExecutionThread: IPostExecutionThread) {

    // region properties

    private var subscription = Subscriptions.empty()

    // endregion


    // region UseCase

    /**
     * Executes the current use case.
     *
     * @param UseCaseSubscriber The guy who will be listen to the observable build with [.buildUseCaseObservable].
     */
    @SuppressWarnings("unchecked")
    fun execute(UseCaseSubscriber: Subscriber<Any>) {
        subscription = buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber)
    }

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    protected abstract fun buildUseCaseObservable(): Observable<Any>

    /**
     * Unsubscribes from current [Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

    // endregion

}