package com.slimshady.weather.data.remote.model

import com.slimshady.weather.data.remote.model.HitsItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(

    @Json(name = "hits")
    val hits: List<HitsItem?>? = null
)
