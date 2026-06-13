package com.androidengineer.tiffunapp

import kotlinx.serialization.Serializable

@Serializable
data class PlacesResponse(
    val places: List<Place> = emptyList()
)

@Serializable
data class Place(
    val id: String = "",
    val displayName: LocalizedText = LocalizedText(""),
    val formattedAddress: String? = null,
    val location: LatLng? = null
)

@Serializable
data class LocalizedText(
    val text: String = ""
)

@Serializable
data class LatLng(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)