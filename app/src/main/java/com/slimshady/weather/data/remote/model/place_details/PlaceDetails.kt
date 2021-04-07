package com.slimshady.weather.data.remote.model.place_details
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/** @author @buren ---> {Google response for place details}*/
@Parcelize
@JsonClass(generateAdapter = true)
data class PlaceDetails (

    @Json(name = "utc_offset")
    var utcOffset: Int? = null,

    @Json(name = "formatted_address")
    var formattedAddress: String? = null,

    @Json(name = "types")
    var types: List<String?>? = null,

    @Json(name = "website")
    var website: String? = null,

    @Json(name = "icon")
    var icon: String? = null,

    @Json(name = "rating")
    var rating: Double? = null,

    @Json(name = "address_components")
    var addressComponents: List<AddressComponentsItem?>? = null,

    @Json(name = "photos")
    var photos: List<PhotosItem?>? = null,

    @Json(name = "url")
    var url: String? = null,

    @Json(name = "reference")
    var reference: String? = null,

    @Json(name = "user_ratings_total")
    var userRatingsTotal: Int? = null,

    @Json(name = "reviews")
    var reviews: List<ReviewsItem?>? = null,

    @Json(name = "scope")
    var scope: String? = null,

    @Json(name = "name")
    var name: String? = null,

    @Json(name = "opening_hours")
    var openingHours: OpeningHours? = null,

    @Json(name = "geometry")
    var geometry: Geometry? = null,

    @Json(name = "vicinity")
    var vicinity: String? = null,

    @Json(name = "id")
    var id: String? = null,

    @Json(name = "adr_address")
    var adrAddress: String? = null,

    @Json(name = "plus_code")
    var plusCode: PlusCode? = null,

    @Json(name = "formatted_phone_number")
    var formattedPhoneNumber: String? = null,

    @Json(name = "international_phone_number")
    var internationalPhoneNumber: String? = null,

    @Json(name = "place_id")
    var placeId: String? = null
) : Parcelable