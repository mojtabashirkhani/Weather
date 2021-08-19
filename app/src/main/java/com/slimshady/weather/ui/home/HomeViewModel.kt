package com.slimshady.weather.ui.home

import androidx.lifecycle.*

import com.slimshady.weather.data.remote.usecase.CurrentWeatherUseCase
import com.slimshady.weather.data.remote.usecase.ForecastUseCase
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-24
 */

class HomeViewModel @Inject internal constructor(
    private val forecastUseCase: ForecastUseCase,
    private val currentWeatherUseCase: CurrentWeatherUseCase) : ViewModel() {

    private val _forecastParams: MutableLiveData<ForecastUseCase.ForecastParams> = MutableLiveData()
    private val _currentWeatherParams: MutableLiveData<CurrentWeatherUseCase.CurrentWeatherParams> =
        MutableLiveData()

    fun getForecastViewState() = forecastViewState
    fun getCurrentWeatherViewState() = currentWeatherViewState


    private val forecastViewState: LiveData<ForecastViewState> =
        _forecastParams.switchMap { params ->
            forecastUseCase.execute(params)
        }
    private val currentWeatherViewState: LiveData<CurrentWeatherViewState> =
        _currentWeatherParams.switchMap { params ->
            currentWeatherUseCase.execute(params)
        }

    fun setForecastParams(params: ForecastUseCase.ForecastParams) {
        if (_forecastParams.value == params)
            return
        _forecastParams.postValue(params)
    }

    fun setCurrentWeatherParams(params: CurrentWeatherUseCase.CurrentWeatherParams) {
        if (_currentWeatherParams.value == params)
            return
        _currentWeatherParams.postValue(params)
    }
}
