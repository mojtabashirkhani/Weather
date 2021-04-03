package com.slimshady.weather.data.remote

import com.slimshady.weather.data.remote.model.place_details.PlacesDetailsResponse
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MapApi {


    @GET("details/json")
    fun getPlaceDetailsFromPlaceId(
        @Query("placeid") placeId: String, @Query("key") apiKey: String
    ): Single<PlacesDetailsResponse>

    @GET("autocomplete/json")
    fun getPlaceResults(
        @Query("input") placeHint: String, @Query("key") apiKey: String, @Query("location") location: String, @Query(
            "radius"
        ) radius: String
    ): Single<SearchResponse>

}