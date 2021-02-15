package com.slimshady.weather.ui.search

import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.util.domain.Status

class SearchViewState(
    val status: Status,
    val error: String? = null
) : BaseViewState(status, error) {
}