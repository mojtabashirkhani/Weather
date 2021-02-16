package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
data class Location(

    @Json(name = "lng")
    var lng: Double? = null,

    @Json(name = "lat")
    var lat: Double? = null
) : Parcelable