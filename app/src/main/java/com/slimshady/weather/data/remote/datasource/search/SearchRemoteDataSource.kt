package com.slimshady.weather.data.remote.datasource.search

import com.slimshady.weather.core.Constants.NetworkService.API_KEY_MAP
import com.slimshady.weather.core.Constants.NetworkService.PLACE_AUTOCOMPLETE_RADIUS
import com.slimshady.weather.data.remote.MapApi
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import io.reactivex.Single
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(private val mapApi: MapApi) {

    fun getCitiesBySearch(city: String): Single<SearchResponse> = mapApi.getPlaceResults(city, API_KEY_MAP, "", PLACE_AUTOCOMPLETE_RADIUS)
}