package com.interpos.coleschallengeapp.feature_menu.data.util

import java.lang.reflect.Type

interface JsonParser {
    fun <T> fromJSON(json : String, convertType : Type) : T?
    fun <T> toJSON(convertingObject : T, convertingType : Type) : String? // May leads to null
}