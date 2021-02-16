package com.slimshady.weather.data.remote.model.weather

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class City(

    @Json(name = "country")
    val country: String?,

    @Json(name = "coord")
    val coord: Coord?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: Int?
) : Parcelable
