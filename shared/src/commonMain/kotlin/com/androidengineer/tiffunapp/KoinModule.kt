package com.androidengineer.tiffunapp

import io.ktor.client.HttpClient
import org.koin.dsl.module
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import kotlin.math.sin

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    // Inject the key from a BuildConfig or environment variable
    single { PlacesService(get(), "AIzaSyDNyXv62WPLJGlb3SL5AHEw8CvRbTaL6cc") }

    single { SearchRepository(get()) }
    viewModelOf(::SearchViewModel)
}

// In commonMain
fun initKoin() {
    startKoin {
        modules(appModule)
    }
}