package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
@JsonClass(generateAdapter = true)
data class PeriodsItem(

    @Json(name = "close")
    var close: Close? = null,

    @Json(name = "open")
    var open: Open? = null
) : Parcelable