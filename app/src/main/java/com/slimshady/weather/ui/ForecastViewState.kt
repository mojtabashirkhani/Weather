package com.slimshady.weather.ui

import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.util.domain.Status


/**
 * Created by Furkan on 2019-10-23
 */

class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
