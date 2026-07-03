package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.download_app_store
import tiffunapp.shared.generated.resources.download_play_store
import tiffunapp.shared.generated.resources.menu_icon
import tiffunapp.shared.generated.resources.splash_screen_image
import tiffunapp.shared.generated.resources.tiffun
import kotlin.time.Duration.Companion.milliseconds

@Preview
@Composable
fun SplashScreen() {

    val startApp = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (!startApp.value) {
            LaunchedEffect(Unit) {
                delay(5000.milliseconds)
                startApp.value = true
            }

            SplashScreenUI()
        } else {
            App()
        }
    }
}

@Composable
fun SplashScreenUI() {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = Color.White).padding(0.dp,70.dp,0.dp,20.dp)
        ) {

            Image(
                painterResource(Res.drawable.tiffun),
                contentDescription = "",
                modifier = Modifier.padding(13.07.dp,0.dp,0.dp,0.dp)
            )

            Image(
                modifier = Modifier.padding(0.dp,0.dp,21.dp,0.dp),
                painter = painterResource(Res.drawable.menu_icon),
                contentDescription = ""
            )
        }

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(Res.drawable.splash_screen_image),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.16.dp,20.dp,5.dp,0.dp),
            text = "Looking for your next meal?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Text(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(9.dp,8.51.dp,5.dp,0.dp),
            text = "Just order Tiffun!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6F7382)
        )

        Text(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp,32.89.dp,5.dp,0.dp),
            text = "Get the best experience with Tiffun",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        Row (
            modifier = Modifier.wrapContentSize().padding(10.65.dp,15.dp,0.dp,50.dp),
        ) {
            Image(
                painter = painterResource(Res.drawable.download_app_store),
                contentDescription = ""
            )

            Image(
                modifier = Modifier.wrapContentSize().padding(17.dp,0.dp,0.dp,0.dp),
                painter = painterResource(Res.drawable.download_play_store),
                contentDescription = ""
            )
        }
    }
}