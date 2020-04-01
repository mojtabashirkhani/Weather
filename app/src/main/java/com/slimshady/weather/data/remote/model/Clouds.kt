package com.slimshady.weather.data.remote.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all: Int?
) : Parcelable
