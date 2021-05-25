package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MapIR (
    @Json(name = "odata.count")
    val odata: Int,


    @Json(name = "value")
    val value: List<Value>
)