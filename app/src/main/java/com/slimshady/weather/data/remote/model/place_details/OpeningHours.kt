package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
@JsonClass(generateAdapter = true)
data class OpeningHours(

    @Json(name = "open_now")
    var openNow: Boolean? = null,

    @Json(name = "periods")
    var periods: List<PeriodsItem?>? = null,

    @Json(name = "weekday_text")
    var weekdayText: List<String?>? = null
) : Parcelable