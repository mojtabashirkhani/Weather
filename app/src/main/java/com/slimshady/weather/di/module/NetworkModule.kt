package com.slimshady.weather.di.module

import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.remote.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

   /* @Singleton
    @Provides
    @Named("cached")
    fun provideOkHttpClient(): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024)
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(DefaultRequestInterceptor())
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    @Named("non_cached")
    fun provideNonCachedOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(DefaultRequestInterceptor())
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }*/

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit.Builder): WeatherApi {
        return retrofit.baseUrl(Constants.NetworkService.BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }
}