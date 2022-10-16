package com.interpos.coleschallengeapp.application.share

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Filter out null values from liveData.value
 */
fun <T> LifecycleOwner.observeNonNull(liveData: LiveData<T>, f: (T) -> Unit) {
    liveData.observe(this) { t -> t?.let(f) }
}