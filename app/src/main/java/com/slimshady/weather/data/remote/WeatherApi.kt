package com.slimshady.weather.data.remote

import com.slimshady.weather.data.remote.model.weather.CurrentWeatherResponse
import com.slimshady.weather.data.remote.model.weather.ForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getForecastByGeoCords(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): Single<ForecastResponse>

    @GET("weather")
    fun getCurrentByGeoCords(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): Single<CurrentWeatherResponse>

    @GET("weather")
    fun getCurrentWeatherByCityName(
        @Query("q")
        cityName: String,
        @Query("units")
        units: String,
        @Query("appid")
        apiKey: String
    ): Single<CurrentWeatherResponse>

    @GET("weather")
    fun getForecastWeatherByCityName(
        @Query("q")
        cityName: String,
        @Query("units")
        units: String,
        @Query("appid")
        apiKey: String
    ): Single<ForecastResponse>
}