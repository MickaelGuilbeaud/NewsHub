package com.newshub.domain.common.interactors

import rx.Subscriber

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
open class DefaultSubscriber<Any> : Subscriber<Any>() {

    override fun onCompleted() {
        // no-op by default.
    }

    override fun onError(e: Throwable) {
        // no-op by default.
    }

    override fun onNext(t: Any?) {
        // no-op by default.
    }

}
