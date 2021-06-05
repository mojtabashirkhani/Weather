package com.slimshady.weather.data.remote

import com.slimshady.weather.core.Constants
import com.slimshady.weather.core.Constants.NetworkService.API_KEY_MAP
import com.slimshady.weather.core.Constants.NetworkService.PLACE_AUTOCOMPLETE_RADIUS
import com.slimshady.weather.data.remote.model.place_details.PlacesDetailsResponse
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MapApi {


  /*  @Headers(Constants.ApiFields.HEADER_ACCEPT_ENCODING)
    @GET(Constants.ApiRoutes.GOOGLE_PLACE_DETAILS)
    fun getPlaceDetailsFromPlaceId(
        @Query("place_id") placeId: String,
        @Query("key") googleMapApiKey: String = API_KEY_MAP
    ): Single<PlacesDetailsResponse>

    @Headers(Constants.ApiFields.HEADER_ACCEPT_ENCODING)
    @GET(Constants.ApiRoutes.GOOGLE_PLACE_AUTOCOMPLETE)
    fun getPlaceResults(
        @Query("input") input: String?,
        @Query("radius") radius: String = PLACE_AUTOCOMPLETE_RADIUS,
        @Query("key") googleMapApiKey: String = API_KEY_MAP
    ): Single<SearchResponse>*/


data class Geom(
    val coordinates: List<Double>,
    val type: String
)
}