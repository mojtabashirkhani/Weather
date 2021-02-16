package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json

/** @author @buren ---> {Google response for predicted places}*/
data class SearchResponse(

	@Json(name = "predictions")
	val predictions: List<PredictionsItem?>? = null,

	@Json(name = "status")
	val status: String? = null
)