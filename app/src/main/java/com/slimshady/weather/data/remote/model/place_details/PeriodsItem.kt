package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
data class PeriodsItem(

    @Json(name = "close")
    var close: Close? = null,

    @Json(name = "open")
    var open: Open? = null
) : Parcelable