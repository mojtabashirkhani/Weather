package com.slimshady.weather.repo

import android.os.Build
import androidx.lifecycle.LiveData
import com.slimshady.weather.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.data.remote.datasource.forecast.ForecastLocalDataSource
import com.slimshady.weather.data.remote.datasource.forecast.ForecastRemoteDataSource
import com.slimshady.weather.data.remote.model.ForecastResponse
import com.slimshady.weather.util.domain.RateLimiter
import com.slimshady.weather.util.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-21
 */

class ForecastRepository @Inject constructor(
    private val forecastRemoteDataSource: ForecastRemoteDataSource,
    private val forecastLocalDataSource: ForecastLocalDataSource
) {

    private val forecastListRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadForecastByCoord(lat: Double, lon: Double, fetchRequired: Boolean, units: String): LiveData<Resource<ForecastEntity>> {
        return object : NetworkBoundResource<ForecastEntity, ForecastResponse>() {
            override fun saveCallResult(item: ForecastResponse) = forecastLocalDataSource.insertForecast(item)

            override fun shouldFetch(data: ForecastEntity?): Boolean = fetchRequired

            override fun loadFromDb(): LiveData<ForecastEntity> = forecastLocalDataSource.getForecast()

            override fun createCall(): Single<ForecastResponse> = forecastRemoteDataSource.getForecastByGeoCords(lat, lon, units)

            override fun onFetchFailed() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                forecastListRateLimit.reset(RATE_LIMITER_TYPE)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        }.asLiveData
    }
}
