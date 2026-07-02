package com.androidengineer.tiffunapp

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<PlacesSearch> { 
        AndroidPlacesSearch(androidContext(), "AIzaSyDNyXv62WPLJGlb3SL5AHEw8CvRbTaL6cc")
    }
}