package com.slimshady.weather.data.remote.datasource.forecast


import com.slimshady.weather.data.remote.WeatherApi
import com.slimshady.weather.data.remote.model.weather.ForecastResponse
import io.reactivex.Single
import javax.inject.Inject


class ForecastRemoteDataSource @Inject constructor(private val api: WeatherApi) {

    fun getForecastByGeoCords(lat: Double, lon: Double, units: String): Single<ForecastResponse> = api.getForecastByGeoCords(lat, lon, units)
}
