package com.slimshady.weather.di.builder


import com.slimshady.weather.ui.home.HomeFragment
import com.slimshady.weather.ui.search.SearchFragment
import com.slimshady.weather.ui.weather_detail.WeatherDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun provideWeatherDetailFragment(): WeatherDetailFragment

}