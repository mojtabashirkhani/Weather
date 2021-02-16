package com.slimshady.weather.data.remote.model.place_details

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
data class Geometry(

    @Json(name = "viewport")
    var viewport: Viewport? = null,

    @Json(name = "location")
    var location: Location? = null
) : Parcelable