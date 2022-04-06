package com.slimshady.weather.data.remote.datasource.currentWeather

import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.remote.model.weather.CurrentWeatherResponse
import javax.inject.Inject



class CurrentWeatherLocalDataSource @Inject constructor(private val currentWeatherDao: CurrentWeatherDao) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )
}
