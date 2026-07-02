package com.androidengineer.tiffunapp

import androidx.compose.ui.window.ComposeUIViewController
import cocoapods.GoogleMaps.GMSServices
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(): UIViewController {
    // 1. Provide the API key immediately when the controller is requested
    GMSServices.provideAPIKey("AIzaSyACdqXM8yUKfC1P4J07xteYnn9vM-5jAcY")

    initKoin { }

    // 2. Return the Compose UI
    return ComposeUIViewController {
        App()
    }
}