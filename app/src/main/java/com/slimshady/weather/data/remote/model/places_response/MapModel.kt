package com.slimshady.weather.data.remote.model.places_response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class MapModel (
    @Json(name = "odata.count")
    val odata: Int?,


    @Json(name = "value")
    val value: @RawValue List<Value>?
): Parcelable