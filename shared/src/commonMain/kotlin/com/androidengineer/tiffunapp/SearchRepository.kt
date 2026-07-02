package com.androidengineer.tiffunapp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepository (
    private val placesSearch: PlacesSearch
) {

    fun searchResults(query: String): Flow<Place> = flow {
        val results = placesSearch.searchAddress(query)

        try {
            if (results.isNotEmpty()) {
                val place = results.first()
                emit(place)
                println("PLACE_FOUND: Lat: ${place.location?.latitude} Long: ${place.location?.longitude}")
            } else {
                println("PLACE_ERROR: No results found in the list.")
            }
        } catch (e: Exception) {
            println("PLACE_CRASH: ${e.message}")
            e.printStackTrace()
        }
    }

}