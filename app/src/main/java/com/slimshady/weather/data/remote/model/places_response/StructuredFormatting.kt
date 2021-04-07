package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** @author @buren ---> {Google response for predicted places}*/
@JsonClass(generateAdapter = true)
data class StructuredFormatting(

    @Json(name = "main_text_matched_substrings")
	val mainTextMatchedSubstrings: List<MainTextMatchedSubstringsItem?>? = null,

    @Json(name = "secondary_text")
	val secondaryText: String? = null,

    @Json(name = "main_text")
	val mainText: String? = null
)