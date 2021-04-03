package com.slimshady.weather.repo

import android.os.Build
import androidx.lifecycle.LiveData
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.local.db.model.SearchEntity
import com.slimshady.weather.data.remote.datasource.search.SearchLocalDataSource
import com.slimshady.weather.data.remote.datasource.search.SearchRemoteDataSource
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import com.slimshady.weather.data.remote.model.weather.CurrentWeatherResponse
import com.slimshady.weather.ui.search.SearchViewState
import com.slimshady.weather.util.domain.RateLimiter
import com.slimshady.weather.util.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchRepository @Inject constructor(
   private val searchRemoteDataSource: SearchRemoteDataSource,
   private val searchLocalDataSource: SearchLocalDataSource
) {

    private val searchRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadCitiesByCityName(cityName: String): LiveData<Resource<SearchEntity>> {
        return object : NetworkBoundResource<SearchEntity, SearchResponse>() {

            override fun saveCallResult(item: SearchResponse) =  searchLocalDataSource.insertSearch(item)

            //Should customize for map and delete this useless func
            override fun shouldFetch(data: SearchEntity?): Boolean = true

            override fun loadFromDb(): LiveData<SearchEntity> = searchLocalDataSource.getSearch()

            override fun createCall(): Single<SearchResponse> = searchRemoteDataSource.getCitiesBySearch(cityName)

            override fun onFetchFailed() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                searchRateLimit.reset(Constants.NetworkService.RATE_LIMITER_TYPE)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        }.asLiveData
    }

}