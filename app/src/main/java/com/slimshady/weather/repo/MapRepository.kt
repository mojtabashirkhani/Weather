package com.slimshady.weather.repo

import android.os.Build
import androidx.lifecycle.LiveData
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.data.remote.datasource.search.SearchLocalDataSource
import com.slimshady.weather.data.remote.datasource.search.SearchRemoteDataSource
import com.slimshady.weather.data.remote.model.places_response.MapModel
import com.slimshady.weather.util.domain.RateLimiter
import com.slimshady.weather.util.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val searchLocalDataSource: SearchLocalDataSource
) {

    private val searchCitiesRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadCitiesByCityName(text: String, select: String, fetchRequired: Boolean): LiveData<Resource<MapEntity>> {
        return object : NetworkBoundResource<MapEntity, MapModel>() {
            override fun saveCallResult(item: MapModel) = searchLocalDataSource.addSearchItem(item)

            override fun shouldFetch(data: MapEntity?): Boolean = fetchRequired

            override fun loadFromDb(): LiveData<MapEntity> = searchLocalDataSource.getRecentSearches()

            override fun createCall(): Single<MapModel> = searchRemoteDataSource.getPlaceResults(text, select)

            override fun onFetchFailed() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                searchCitiesRateLimit.reset(Constants.NetworkService.RATE_LIMITER_TYPE)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        }.asLiveData
    }

}