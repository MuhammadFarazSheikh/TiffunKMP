package com.androidengineer.tiffunapp

import android.app.Application

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}