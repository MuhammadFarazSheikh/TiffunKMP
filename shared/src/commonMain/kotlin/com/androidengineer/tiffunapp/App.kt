package com.androidengineer.tiffunapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Preview
@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = ScreenState.SignupScreenDestination
        ){
            composable< ScreenState.SignupScreenDestination>{ backStackEntry ->
                UserSignup(onSignupClick = {
                    navController.navigate(ScreenState.PhoneNumberScreenDestination)
                })
            }

            composable< ScreenState.PhoneNumberScreenDestination>{ backStackEntry ->
                UserPhoneNumber()
            }
        }
    }
}

@Serializable
sealed class ScreenState {
    @Serializable object SignupScreenDestination: ScreenState()
    @Serializable object PhoneNumberScreenDestination: ScreenState()
}