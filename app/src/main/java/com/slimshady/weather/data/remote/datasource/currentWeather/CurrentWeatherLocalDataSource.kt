package com.slimshady.weather.data.remote.datasource.currentWeather

import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.remote.model.CurrentWeatherResponse
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-24
 */

class CurrentWeatherLocalDataSource @Inject constructor(private val currentWeatherDao: CurrentWeatherDao) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )
}
