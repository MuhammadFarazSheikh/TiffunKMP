package com.androidengineer.tiffunapp

import org.koin.dsl.module
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration

val appModule = module {
    includes(platformModule)
    single { SearchRepository(get()) }
    viewModelOf(::SearchViewModel)
}

expect val platformModule: Module

// In commonMain
fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(appModule)
    }
}