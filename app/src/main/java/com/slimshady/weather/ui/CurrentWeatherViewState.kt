package com.slimshady.weather.ui

import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.util.domain.Status


/**
 * Created by Furkan on 2019-10-24
 */

class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: CurrentWeatherEntity? = null
) : BaseViewState(status, error) {
    fun getCurrentWeather() = data
}
