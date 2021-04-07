package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/

@Entity(tableName = "ReviewsItem")
@Parcelize
@JsonClass(generateAdapter = true)
data class ReviewsItem(

    @Json(name = "author_name")
    var authorName: String? = null,

    @Json(name = "profile_photo_url")
    var profilePhotoUrl: String? = null,

    @Json(name = "author_url")
    var authorUrl: String? = null,

    @Json(name = "rating")
    var rating: Int? = null,

    @Json(name = "language")
    var language: String? = null,

    @Json(name = "text")
    var text: String? = null,

    @Json(name = "time")
    var time: Int? = null,

    @Json(name = "relative_time_description")
    var relativeTimeDescription: String? = null

) : Parcelable