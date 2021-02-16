package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
data class Open(

    @Json(name = "time")
    var time: String? = null,

    @Json(name = "day")
    var day: Int? = null
) : Parcelable