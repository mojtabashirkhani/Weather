package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
@JsonClass(generateAdapter = true)
data class Location(

    @Json(name = "lng")
    var lng: Double? = null,

    @Json(name = "lat")
    var lat: Double? = null
) : Parcelable