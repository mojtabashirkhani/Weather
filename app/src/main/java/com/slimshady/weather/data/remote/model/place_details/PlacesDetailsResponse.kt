package com.slimshady.weather.data.remote.model.place_details
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

/** @author @buren ---> {Google response for place details}*/
@Generated("com.robohorse.robopojogenerator")
data class PlacesDetailsResponse(

    @field:SerializedName("result")
    var result: PlaceDetails? = null,

    @field:SerializedName("html_attributions")
    var htmlAttributions: List<Any?>? = null,

    @field:SerializedName("status")
    var status: String? = null
)