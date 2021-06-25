package com.slimshady.weather.data.remote.model.places_response

import android.os.Parcelable
import com.slimshady.weather.data.remote.MapApi
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class Value(
    @Json(name = "address")
    val address: String?,

    @Json(name = "city")
    val city: String?,

    @Json(name = "county")
    val county: String?,

    @Json(name = "district")
    val district: String?,

    @Json(name = "fclass")
    val fclass: String?,

    @Json(name = "geom")
    val geom: Geom?,

    @Json(name = "neighborhood")
    val neighborhood: String?,

    @Json(name = "province")
    val province: String?,

    @Json(name = "region")
    val region: String?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "type")
    val type: String?
):Parcelable