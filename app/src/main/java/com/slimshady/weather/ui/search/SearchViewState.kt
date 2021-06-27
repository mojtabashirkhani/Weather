package com.slimshady.weather.ui.search

import com.slimshady.weather.base.BaseViewState
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.util.domain.Status

class SearchViewState(
    val status: Status,
    val error: String? = null,
    val data: MapEntity? = null
) : BaseViewState(status, error) {
    fun getSearch() = data
}