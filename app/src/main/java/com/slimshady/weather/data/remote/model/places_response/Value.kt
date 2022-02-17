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
    @Transient
    var address: String? = "",

    @Json(name = "city")
    var city: String? = "",

    @Json(name = "county")
    var county: String? = "",

    @Json(name = "district")
    @Transient
    var district: String? = "",

    @Json(name = "fclass")
    @Transient
    var fclass: String? = "",

    @Json(name = "geom")
    val geom: Geom?,

    @Json(name = "neighborhood")
    @Transient
    var neighborhood: String? = "",

    @Json(name = "province")
    var province: String? = "",

    @Json(name = "region")
    @Transient
    var region: String? = "",

    @Json(name = "title")
    @Transient
    var title: String? = "",

    @Json(name = "type")
    @Transient
    var type: String?  = ""
):Parcelable