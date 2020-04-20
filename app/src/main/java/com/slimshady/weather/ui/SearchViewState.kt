package com.slimshady.weather.ui

import com.faskn.app.weatherapp.core.BaseViewState
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import com.slimshady.weather.util.domain.Status


/**
 * Created by Furkan on 2019-10-31
 */

class SearchViewState(
    val status: Status,
    val error: String? = null,
    val data: List<CitiesForSearchEntity>? = null
) : BaseViewState(status, error) {
    fun getSearchResult() = data
}
