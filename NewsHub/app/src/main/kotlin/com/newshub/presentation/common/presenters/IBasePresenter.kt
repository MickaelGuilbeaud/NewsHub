package com.newshub.presentation.common.presenters

/**
 * Base Presenter interface that every presenter should extends, it contains base methods to manipulate a Presenter.
 * Presenter interfaces expose methods needed to react to user interactions coming from the view.
 */
interface IBasePresenter<T> {

    /**
     * Set the view to manage.
     */
    fun setView(view: T)

    /**
     * Method to call to notify the Presenter when the view is destroyed. This is at this point that every UseCase
     * should be unsubscribed in order to avoid memory leaks.
     */
    fun destroy()

}
