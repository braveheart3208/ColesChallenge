package com.interpos.coleschallengeapp.feature_menu.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class ResultInteractor<in P, R> {
    abstract val dispatcher: CoroutineDispatcher

    suspend operator fun invoke(params: P): R {
        return withContext(dispatcher) { doWork(params) }
    }

    protected abstract suspend fun doWork(params: P): R
}