package com.slimshady.weather.data.remote.datasource.search

import com.slimshady.weather.data.remote.MapApi
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(private val mapApi: MapApi) {

    fun getPlaceResults(text: String, select: String) = mapApi.getPlaceResults(text, select)
}