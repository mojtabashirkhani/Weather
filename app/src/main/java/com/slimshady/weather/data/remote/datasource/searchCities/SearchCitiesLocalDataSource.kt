package com.slimshady.weather.data.remote.datasource.searchCities

import androidx.lifecycle.LiveData
import com.slimshady.weather.data.local.db.dao.CitiesForSearchDao
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import com.slimshady.weather.data.remote.model.SearchResponse
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-31
 */

class SearchCitiesLocalDataSource @Inject constructor(private val citiesForSearchDao: CitiesForSearchDao) {

    fun getCityByName(cityName: String?): LiveData<List<CitiesForSearchEntity>> = citiesForSearchDao.getCityByName(cityName)

    fun insertCities(response: SearchResponse) {
        response.hits
            ?.map { CitiesForSearchEntity(it) }
            ?.let { citiesForSearchDao.insertCities(it) }
    }
}
