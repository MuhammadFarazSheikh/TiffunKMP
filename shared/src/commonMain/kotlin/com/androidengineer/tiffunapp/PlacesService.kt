package com.androidengineer.tiffunapp

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class PlacesService(
    private val client: HttpClient,
    private val apiKey: String
) {
    suspend fun searchAddress(query: String): List<Place> {
        val response = client.post("https://places.googleapis.com/v1/places:searchText") {
            header("X-Goog-Api-Key", apiKey)
            header("X-Goog-FieldMask", "places.id,places.displayName,places.formattedAddress,places.location")
            contentType(ContentType.Application.Json)
            setBody(mapOf("textQuery" to query))
        }

        val responseBody = response.bodyAsText()
        println("Places API Response ($query): $responseBody")

        if (response.status == HttpStatusCode.OK) {
            return response.body<PlacesResponse>().places
        } else {
            return emptyList()
        }
    }
}