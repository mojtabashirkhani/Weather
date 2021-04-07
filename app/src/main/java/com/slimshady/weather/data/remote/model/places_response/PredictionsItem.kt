package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** @author @buren ---> {Google response for predicted places}*/
@JsonClass(generateAdapter = true)
data class PredictionsItem(

    @Json(name = "reference")
    val reference: String? = null,

    @Json(name = "types")
    val types: List<String?>? = null,

    @Json(name = "matched_substrings")
    val matchedSubstrings: List<MatchedSubstringsItem?>? = null,

    @Json(name = "terms")
    val terms: List<TermsItem?>? = null,

    @Json(name = "structured_formatting")
    val structuredFormatting: StructuredFormatting? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "place_id")
    val placeId: String? = null
)