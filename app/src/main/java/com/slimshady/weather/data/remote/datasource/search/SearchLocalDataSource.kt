package com.slimshady.weather.data.remote.datasource.search

import androidx.lifecycle.LiveData
import com.slimshady.weather.data.local.db.dao.RecentSearchesDAO
import com.slimshady.weather.data.local.db.model.SearchEntity
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import javax.inject.Inject

class SearchLocalDataSource @Inject constructor(private val searchesDAO: RecentSearchesDAO)  {

    fun getSearch() = searchesDAO.getRecentSearches()

    fun  insertSearch(searchResponse: SearchResponse) = searchesDAO.addSearchItem(SearchEntity(searchResponse))
}