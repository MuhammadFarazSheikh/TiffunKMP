package com.androidengineer.tiffunapp

import cocoapods.GooglePlaces.*
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

@OptIn(ExperimentalForeignApi::class)
class IosPlacesSearch(
    private val apiKey: String
) : PlacesSearch {

    init {
        GMSPlacesClient.provideAPIKey(apiKey)
    }

    private val placesClient = GMSPlacesClient.sharedClient()

    override suspend fun searchAddress(query: String): List<Place> {
        val prediction = suspendCancellableCoroutine<GMSAutocompletePrediction?> { continuation ->
            placesClient.findAutocompletePredictionsFromQuery(
                query,
                null,
                null
            ) { predictions, error ->
                if (error != null) {
                    continuation.resume(null)
                    return@findAutocompletePredictionsFromQuery
                }
                continuation.resume(predictions?.firstOrNull() as? GMSAutocompletePrediction)
            }
        } ?: return emptyList()

        return suspendCancellableCoroutine { continuation ->
            placesClient.lookUpPlaceID(prediction.placeID!!) { gmsPlace, error ->
                if (error != null || gmsPlace == null) {
                    continuation.resume(listOf(Place(
                        id = prediction.placeID!!,
                        displayName = LocalizedText(prediction.attributedFullText.string()),
                        formattedAddress = prediction.attributedFullText.string(),
                        location = null
                    )))
                    return@lookUpPlaceID
                }

                val latLng = gmsPlace.coordinate.useContents {
                    LatLng(latitude, longitude)
                }

                continuation.resume(listOf(Place(
                    id = gmsPlace.placeID ?: "",
                    displayName = LocalizedText(gmsPlace.name ?: ""),
                    formattedAddress = gmsPlace.formattedAddress,
                    location = latLng
                )))
            }
        }
    }
}