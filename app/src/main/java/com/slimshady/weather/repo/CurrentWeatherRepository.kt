package com.slimshady.weather.repo

import android.os.Build
import androidx.lifecycle.LiveData
import com.slimshady.weather.data.remote.datasource.currentWeather.CurrentWeatherRemoteDataSource
import com.slimshady.weather.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.remote.datasource.currentWeather.CurrentWeatherLocalDataSource
import com.slimshady.weather.data.remote.model.weather.CurrentWeatherResponse
import com.slimshady.weather.util.domain.RateLimiter
import com.slimshady.weather.util.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject



class CurrentWeatherRepository @Inject constructor(
    private val currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource,
    private val currentWeatherLocalDataSource: CurrentWeatherLocalDataSource
) {

    private val currentWeatherRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadCurrentWeatherByGeoCords(lat: Double, lon: Double, fetchRequired: Boolean, units: String): LiveData<Resource<CurrentWeatherEntity>> {
        return object : NetworkBoundResource<CurrentWeatherEntity, CurrentWeatherResponse>() {
            override fun saveCallResult(item: CurrentWeatherResponse) = currentWeatherLocalDataSource.insertCurrentWeather(item)

            override fun shouldFetch(data: CurrentWeatherEntity?): Boolean = fetchRequired

            override fun loadFromDb(): LiveData<CurrentWeatherEntity> = currentWeatherLocalDataSource.getCurrentWeather()

            override fun createCall(): Single<CurrentWeatherResponse> = currentWeatherRemoteDataSource.getCurrentWeatherByGeoCords(lat, lon, units)

            override fun onFetchFailed() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                currentWeatherRateLimit.reset(RATE_LIMITER_TYPE)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        }.asLiveData
    }
}
