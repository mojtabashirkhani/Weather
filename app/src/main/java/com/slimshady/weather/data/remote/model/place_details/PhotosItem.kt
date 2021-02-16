package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
data class PhotosItem(

    @Json(name = "photo_reference")
    var photoReference: String? = null,

    @Json(name = "width")
    var width: Int? = null,

    @Json(name = "html_attributions")
    var htmlAttributions: List<String?>? = null,

    @Json(name = "height")
    var height: Int? = null

) : Parcelable