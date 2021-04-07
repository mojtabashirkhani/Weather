package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Entity(tableName = "PlusCode")
@Parcelize
@JsonClass(generateAdapter = true)
data class PlusCode(
    @Json(name = "compound_code")
    var compoundCode: String? = null,

    @Json(name = "global_code")
    var globalCode: String? = null
) : Parcelable