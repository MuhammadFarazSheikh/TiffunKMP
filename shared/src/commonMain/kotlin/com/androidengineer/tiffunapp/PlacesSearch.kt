package com.androidengineer.tiffunapp

interface PlacesSearch {
    suspend fun searchAddress(query: String): List<Place>
}