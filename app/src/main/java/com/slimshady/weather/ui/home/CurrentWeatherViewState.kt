package com.slimshady.weather.ui.home

import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.util.domain.Status



class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: CurrentWeatherEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
