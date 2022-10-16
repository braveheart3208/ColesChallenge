package com.interpos.coleschallengeapp.feature_menu.data.util

import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParser(private val myGson : Gson) : JsonParser {

    override fun <T> fromJSON(json: String, convertType: Type): T? {
        return myGson.fromJson(json, convertType)
    }

    override fun <T> toJSON(convertingObject: T, convertingType: Type): String? {
        return myGson.toJson(convertingObject, convertingType)
    }
}