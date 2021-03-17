package com.slimshady.weather.repo

import com.slimshady.weather.data.remote.datasource.search.SearchLocalDataSource
import com.slimshady.weather.data.remote.datasource.search.SearchRemoteDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(
    searchRemoteDataSource: SearchRemoteDataSource,
    searchLocalDataSource: SearchLocalDataSource
) {

}