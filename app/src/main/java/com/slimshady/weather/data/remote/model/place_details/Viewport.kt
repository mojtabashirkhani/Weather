package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Entity(tableName = "Viewport")
@Parcelize
data class Viewport(

    @PrimaryKey
    @Json(name = "southwest")
    val southwest: Southwest? = null,

    @Json(name = "northeast")
	val northeast: Northeast? = null

) : Parcelable