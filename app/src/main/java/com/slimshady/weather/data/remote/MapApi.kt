package com.slimshady.weather.data.remote

import com.slimshady.weather.data.remote.model.places_response.MapIr
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MapApi {


    @Headers("Content-Type: application/json")
    @GET("search/v2/autocomplete")
    fun getPlaceResults(
        @Query("text") text: String, @Query("\$select") select: String
    ): Single<MapIr>

    data class Geom(
        val coordinates: List<Double>,
        val type: String
    )
}