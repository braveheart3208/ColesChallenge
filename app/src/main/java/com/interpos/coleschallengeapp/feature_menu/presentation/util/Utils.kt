package com.interpos.coleschallengeapp.feature_menu.presentation.util

import android.content.Context
import java.io.IOException
import java.io.InputStream

object Utils {

    fun getJsonFromAssets(context: Context, fileName: String): String {
        var jsonString = ""
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {

        }
        return jsonString
    }
}