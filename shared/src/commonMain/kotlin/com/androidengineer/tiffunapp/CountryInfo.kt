package com.androidengineer.tiffunapp

import kotlinx.serialization.Serializable

@Serializable
data class CountryInfo(
    val code: String = "",
    val phoneCode: String = "",
    val flagEmoji: String = ""
)
