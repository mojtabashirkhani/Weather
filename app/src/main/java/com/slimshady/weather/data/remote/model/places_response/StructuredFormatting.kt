package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json

/** @author @buren ---> {Google response for predicted places}*/
data class StructuredFormatting(

    @Json(name = "main_text_matched_substrings")
	val mainTextMatchedSubstrings: List<MainTextMatchedSubstringsItem?>? = null,

    @Json(name = "secondary_text")
	val secondaryText: String? = null,

    @Json(name = "main_text")
	val mainText: String? = null
)