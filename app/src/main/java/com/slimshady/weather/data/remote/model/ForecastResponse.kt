package com.slimshady.weather.data.remote.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ForecastResponse(

    @Json(name = "city")
    val city: City?,

    @Json(name = "cnt")
    val cnt: Int?,

    @Json(name = "cod")
    val cod: String?,

    @Json(name = "message")
    val message: Double?,

    @Json(name = "list")
    val list: List<ListItem>?
) : Parcelable
