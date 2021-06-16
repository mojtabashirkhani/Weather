package com.slimshady.weather.data.remote

import com.slimshady.weather.core.Constants.NetworkService.API_KEY_MAP
import com.slimshady.weather.data.remote.model.places_response.MapModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MapApi {


    @Headers("Content-Type: application/json", "x-api-key: $API_KEY_MAP")
    @POST("search/v2/autocomplete")
    fun getPlaceResults(
        @Query("text") text: String, @Query("select") select: String
    ): Single<MapModel>


}