package com.interpos.coleschallengeapp.application

import android.app.Application
import com.interpos.coleschallengeapp.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ColesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //Library Initialization Starts Here
        //Timber Log
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}