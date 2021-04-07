package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** @author @buren ---> {Google response for predicted places}*/
@JsonClass(generateAdapter = true)
data class SearchResponse(

	@Json(name = "predictions")
	val predictions: List<PredictionsItem?>? = null,

	@Json(name = "status")
	val status: String? = null
)