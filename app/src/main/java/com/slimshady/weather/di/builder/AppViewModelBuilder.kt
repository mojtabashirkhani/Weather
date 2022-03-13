package com.slimshady.weather.di.builder

import androidx.lifecycle.ViewModel
import com.slimshady.weather.di.qualifier.ViewModelKey
import com.slimshady.weather.ui.home.HomeViewModel
import com.slimshady.weather.ui.home.forecast.ForecastItemViewModel
import com.slimshady.weather.ui.search.SearchViewModel
import com.slimshady.weather.ui.search.result.SearchResultViewModel
import com.slimshady.weather.ui.splash.SplashFragmentViewModel
import com.slimshady.weather.ui.weather_detail.WeatherDetailViewModel
import com.slimshady.weather.ui.weather_detail.weatherHourOfDay.WeatherHourOfDayItemViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchResultViewModel::class)
    abstract fun bindSearchResultViewModel(searchResultViewModel: SearchResultViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForecastItemViewModel::class)
    abstract fun bindForecastItemViewModel(forecastItemViewModel: ForecastItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailViewModel::class)
    abstract fun bindWeatherDetailViewModel(weatherDetailViewModel: WeatherDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherHourOfDayItemViewModel::class)
    abstract fun bindWeatherHourOfDayItemViewModel(weatherHourOfDayItemViewModel: WeatherHourOfDayItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashFragmentViewModel::class)
    abstract fun bindSplashFragmentViewModel(splashFragmentViewModel: SplashFragmentViewModel): ViewModel


}