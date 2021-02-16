package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Entity(tableName = "Southwest")
@Parcelize
data class Southwest(

    @Json(name = "lng")
    var lng: Double? = null,

    @Json(name = "lat")
    var lat: Double? = null
) : Parcelable