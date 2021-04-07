package com.slimshady.weather.data.remote.model.place_details
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** @author @buren ---> {Google response for place details}*/
@JsonClass(generateAdapter = true)
data class PlacesDetailsResponse(

    @Json(name = "result")
    var result: PlaceDetails? = null,

    @Json(name = "html_attributions")
    var htmlAttributions: List<Any?>? = null,

    @Json(name = "status")
    var status: String? = null
)