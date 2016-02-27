package com.newshub.presentation.common.mappers

import java.util.*


/**
 * This class is used to map an object (or Collection) of a class to an object (or Collection) of another class. This
 * abstraction handles Collections and null parameters, allowing the children classes to focus exclusively on the object
 * mapping.
 */
abstract class BaseDataMapper<T, R> {

    /**
     * Transform a Collection of [T] into a List of [R].
     *
     * @param objectEntityCollection Object Collection to be transformed.
     * @return [R] if valid [T] otherwise null.
     */
    fun transform(objectEntityCollection: Collection<T>?): List<R> {
        val objectList = ArrayList<R>()
        if (objectEntityCollection != null) {
            var obj: R?
            for (objectEntity in objectEntityCollection) {
                obj = transform(objectEntity)
                if (obj != null) {
                    objectList.add(obj)
                }
            }
        }
        return objectList
    }

    /**
     * Transform a [T] into a [R].

     * @param objectEntity Object to be transformed.
     * *
     * @return [R] if valid [T] otherwise null.
     */
    fun transform(objectEntity: T?): R? {
        var obj: R? = null
        if (objectEntity != null) {
            obj = createObject(objectEntity)
        }
        return obj
    }

    /**
     * Create a [R] object from a non null [T] object.

     * @param sourceObject source object used for creation the new one
     * *
     * @return R object
     */
    abstract fun createObject(sourceObject: T): R

}
