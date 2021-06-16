package com.slimshady.weather.data.remote.model.places_response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Geom(
    val coordinates: List<Double>,
    val type: String
):Parcelable