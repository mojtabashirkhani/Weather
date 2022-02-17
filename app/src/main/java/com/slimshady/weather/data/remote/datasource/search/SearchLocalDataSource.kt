package com.slimshady.weather.data.remote.datasource.search

import com.slimshady.weather.data.local.db.dao.MapDao
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.data.remote.model.places_response.MapModel
import com.slimshady.weather.data.remote.model.places_response.Value
import javax.inject.Inject

class SearchLocalDataSource @Inject constructor(private val mapDao: MapDao)  {

    fun addSearchItem(mapModel: MapModel) = mapDao.addSearchItem(MapEntity(mapModel))

    fun getRecentSearches()  = mapDao.getRecentSearches()
}