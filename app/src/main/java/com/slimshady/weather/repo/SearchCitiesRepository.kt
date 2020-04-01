package com.slimshady.weather.repo

import android.os.Build
import androidx.lifecycle.LiveData
import com.faskn.app.weatherapp.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.slimshady.weather.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import com.slimshady.weather.data.remote.datasource.searchCities.SearchCitiesLocalDataSource
import com.slimshady.weather.data.remote.model.SearchResponse
import com.slimshady.weather.util.domain.RateLimiter
import com.slimshady.weather.util.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-31
 */

class SearchCitiesRepository @Inject constructor(
    private val searchCitiesLocalDataSource: SearchCitiesLocalDataSource,
    private val searchCitiesRemoteDataSource: SearchCitiesRemoteDataSource
) {

    private val rateLimiter = RateLimiter<String>(1, TimeUnit.SECONDS)

    fun loadCitiesByCityName(cityName: String?): LiveData<Resource<List<CitiesForSearchEntity>>> {
        return object : NetworkBoundResource<List<CitiesForSearchEntity>, SearchResponse>() {
            override fun saveCallResult(item: SearchResponse) = searchCitiesLocalDataSource.insertCities(item)

            override fun shouldFetch(data: List<CitiesForSearchEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<CitiesForSearchEntity>> = searchCitiesLocalDataSource.getCityByName(cityName)

            override fun createCall(): Single<SearchResponse> = searchCitiesRemoteDataSource.getCityWithQuery(
                cityName
                    ?: ""
            )

            override fun onFetchFailed() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                rateLimiter.reset(RATE_LIMITER_TYPE)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        }.asLiveData
    }
}
