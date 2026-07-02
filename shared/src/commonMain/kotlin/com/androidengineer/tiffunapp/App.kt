package com.androidengineer.tiffunapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
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
            composable<ScreenState.SignupScreenDestination>{ backStackEntry ->
                UserSignup(onSignupClick = {
                    navController.navigate(ScreenState.PhoneNumberScreenDestination)
                })
            }

            composable<ScreenState.PhoneNumberScreenDestination>{ backStackEntry ->
                UserPhoneNumber(
                    onNextClick = { countryCode, phoneNumber, countryEmoji ->
                        navController.navigate(ScreenState.VerifyPhoneNumberScreenDestination(phoneNumber = phoneNumber, countryCode = countryCode, countryEmoji = countryEmoji))
                    }
                )
            }

            composable<ScreenState.VerifyPhoneNumberScreenDestination>{ backStackEntry ->
                val routeData = backStackEntry.toRoute<ScreenState.VerifyPhoneNumberScreenDestination>()
                VerifyPhoneNumber(onNextClick = { countryCode, phoneNumber, countryEmoji ->
                    navController.navigate(ScreenState.UserLogin(phoneNumber = phoneNumber, countryCode = countryCode, countryEmoji = countryEmoji))
                }, countryCode = routeData.countryCode, phoneNumber = routeData.phoneNumber, countryEmoji = routeData.countryEmoji)
            }

            composable<ScreenState.UserLogin>{ backStackEntry ->
                val routeData = backStackEntry.toRoute<ScreenState.UserLogin>()
                UserLogin(onLoginClicked = {
                    navController.navigate(ScreenState.PersonalDetails)
                }, countryCode = routeData.countryCode, phoneNumber = routeData.phoneNumber, routeData.countryEmoji)
            }

            composable<ScreenState.PersonalDetails>{ backStackEntry ->
                val routeData = backStackEntry.toRoute<ScreenState.PersonalDetails>()
                PersonalDetails(
                    onNextClick = {
                        navController.navigate(ScreenState.WorkAddress)
                    }
                )
            }

            composable<ScreenState.WorkAddress>{ backStackEntry ->
                val routeData = backStackEntry.toRoute<ScreenState.WorkAddress>()
                WorkAddress(
                    onSaveClick = {
                        navController.navigate(ScreenState.GetStarted)
                    }
                )
            }

            composable<ScreenState.GetStarted>{ backStackEntry ->
                val routeData = backStackEntry.toRoute<ScreenState.GetStarted>()
                GetStarted()
            }
        }
    }
}

@Serializable
sealed class ScreenState {
    @Serializable object SignupScreenDestination: ScreenState()
    @Serializable object PhoneNumberScreenDestination: ScreenState()
    @Serializable data class VerifyPhoneNumberScreenDestination(val phoneNumber: String, val countryCode: String, val countryEmoji: String): ScreenState()
    @Serializable data class UserLogin(val phoneNumber: String, val countryCode: String, val countryEmoji: String): ScreenState()
    @Serializable object PersonalDetails: ScreenState()
    @Serializable object WorkAddress: ScreenState()
    @Serializable object GetStarted: ScreenState()
}