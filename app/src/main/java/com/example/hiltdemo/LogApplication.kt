package com.example.hiltdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LogApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
