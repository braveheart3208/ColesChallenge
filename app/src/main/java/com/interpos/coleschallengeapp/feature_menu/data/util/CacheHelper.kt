package com.interpos.coleschallengeapp.feature_menu.data.util

import java.lang.reflect.Type

interface CacheHelper {
    fun <T> getValueFromCache(key: String, cacheType: Type): T?
    fun <T> cacheValue(key: String, value: T)
}