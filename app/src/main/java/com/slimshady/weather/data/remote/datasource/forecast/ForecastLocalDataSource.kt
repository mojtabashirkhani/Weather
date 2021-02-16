package com.slimshady.weather.data.remote.datasource.forecast


import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.data.remote.model.weather.ForecastResponse
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-21
 */

class ForecastLocalDataSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun getForecast() = forecastDao.getForecast()

    fun insertForecast(forecast: ForecastResponse) = forecastDao.deleteAndInsert(ForecastEntity(forecast))
}
