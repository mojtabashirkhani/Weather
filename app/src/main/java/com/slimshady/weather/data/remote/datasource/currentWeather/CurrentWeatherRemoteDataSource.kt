package com.slimshady.weather.data.remote.datasource.currentWeather


import com.slimshady.weather.data.remote.WeatherApi
import com.slimshady.weather.data.remote.model.weather.CurrentWeatherResponse
import io.reactivex.Single
import javax.inject.Inject


class CurrentWeatherRemoteDataSource @Inject constructor(private val api: WeatherApi) {

    fun getCurrentWeatherByGeoCords(lat: Double, lon: Double, units: String): Single<CurrentWeatherResponse> = api.getCurrentByGeoCords(lat, lon, units)
}
