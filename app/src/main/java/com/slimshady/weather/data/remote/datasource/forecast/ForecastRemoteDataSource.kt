package com.slimshady.weather.data.remote.datasource.forecast


import com.slimshady.weather.data.remote.WeatherApi
import com.slimshady.weather.data.remote.model.ForecastResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-21
 */

class ForecastRemoteDataSource @Inject constructor(private val api: WeatherApi) {

    fun getForecastByGeoCords(lat: Double, lon: Double, units: String): Single<ForecastResponse> = api.getForecastByGeoCords(lat, lon, units)
}
