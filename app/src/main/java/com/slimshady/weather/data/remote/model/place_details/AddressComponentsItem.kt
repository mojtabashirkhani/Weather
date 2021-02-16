package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
class AddressComponentsItem(

    @Json(name = "types")
    var types: List<String?>? = null,

    @Json(name = "short_name")
    var shortName: String? = null,

	@Json(name = "long_name")
    @PrimaryKey var longName: String

) : Parcelable