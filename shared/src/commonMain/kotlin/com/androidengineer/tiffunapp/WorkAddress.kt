package com.androidengineer.tiffunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import eu.buney.maps.CameraUpdateFactory
import eu.buney.maps.GoogleMap
import eu.buney.maps.LatLng
import eu.buney.maps.MapUiSettings
import eu.buney.maps.Marker
import eu.buney.maps.MarkerState
import eu.buney.maps.rememberCameraPositionState
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import tiffunapp.shared.generated.resources.Res
import tiffunapp.shared.generated.resources.tiffun

@Composable
fun WorkAddress() {
    val viewModel : SearchViewModel = koinViewModel()
    val state = viewModel.stateFlow.collectAsStateWithLifecycle().value
    val latLng = remember { mutableStateOf(LatLng(0.0,0.0)) }
    val addressTextField = rememberSaveable { mutableStateOf("") }
    val cameraPositionState = rememberCameraPositionState()

    val newLocation = LatLng(state.location?.latitude ?: 0.0, state.location?.longitude ?: 0.0)
    latLng.value = newLocation

    LaunchedEffect(newLocation) {
        cameraPositionState.animate(
            update = CameraUpdateFactory.newLatLngZoom(newLocation, 15f),
            durationMs = 1000
        )
    }

    Column (
        modifier = Modifier.background(color = Color.White).fillMaxSize()
    ){

        Image(
            painterResource(Res.drawable.tiffun),
            contentDescription = "",
            modifier = Modifier.padding(13.07.dp,48.dp,0.dp,0.dp)
        )

        Text(
            modifier = Modifier.padding(16.dp,15.dp,0.dp,0.dp),
            text = "Enter your work address",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF363B52)
        )

        TextField(
            value = addressTextField.value,
            onValueChange = {
                addressTextField.value = it
            },
            modifier = Modifier.padding(16.dp, 22.dp,16.dp,0.dp).fillMaxWidth().wrapContentHeight().border(width = 1.dp, shape = RoundedCornerShape(5.dp), color = Color(0xFFCFCCD9)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            singleLine = true
        )

        Box(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize().padding(0.dp,10.dp,0.dp,0.dp),
                cameraPositionState = cameraPositionState,
                uiSettings = MapUiSettings(false,
                    myLocationButtonEnabled = false,
                    scrollGesturesEnabled = false,
                    scrollGesturesEnabledDuringRotateOrZoom = false,
                    zoomControlsEnabled = false,
                    zoomGesturesEnabled = false
                )
            ) {
                Marker(state = MarkerState(position = latLng.value), title = state.displayName.text)
            }

            TextButton(
                modifier = Modifier.align(alignment = Alignment.BottomCenter).padding(15.dp,0.dp,15.dp,50.dp).background(color = Color(0xFFE84B4B), shape = RoundedCornerShape(5.dp)).fillMaxWidth().wrapContentHeight(),
                onClick = {
                    viewModel.searchResults(addressTextField.value)
                },
                content = {
                    Text(
                        text = "Save",
                        fontSize = 15.sp,
                        color = Color(0xFFFFFFFF),
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    }
}