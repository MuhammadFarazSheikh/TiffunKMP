package com.androidengineer.tiffunapp

import android.content.Context
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place as GPlace
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.api.net.SearchByTextRequest
import kotlinx.coroutines.tasks.await

class AndroidPlacesSearch(
    private val context: Context,
    private val apiKey: String
) : PlacesSearch {

    private val placesClient: PlacesClient by lazy {
        if (!Places.isInitialized()) {
            Places.initialize(context, apiKey)
        }
        Places.createClient(context)
    }

    override suspend fun searchAddress(query: String): List<Place> {
        val placeFields = listOf(
            GPlace.Field.ID,
            GPlace.Field.DISPLAY_NAME,
            GPlace.Field.FORMATTED_ADDRESS,
            GPlace.Field.LOCATION
        )

        val request = SearchByTextRequest.builder(query, placeFields).build()

        return try {
            val response = placesClient.searchByText(request).await()
            response.places.map { gPlace ->
                Place(
                    id = gPlace.id ?: "",
                    displayName = LocalizedText(gPlace.displayName ?: ""),
                    formattedAddress = gPlace.formattedAddress,
                    location = gPlace.location?.let { LatLng(it.latitude, it.longitude) }
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}