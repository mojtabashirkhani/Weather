package com.slimshady.weather.data.remote.model.places_response

import com.squareup.moshi.Json

/** @author @buren ---> {Google response for predicted places}*/
data class TermsItem(

	@Json(name = "offset")
	val offset: Int? = null,

	@Json(name = "value")
	val value: String? = null
)