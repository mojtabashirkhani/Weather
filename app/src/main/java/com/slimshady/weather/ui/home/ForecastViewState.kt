package com.slimshady.weather.ui.home


import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.util.domain.Status


class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
