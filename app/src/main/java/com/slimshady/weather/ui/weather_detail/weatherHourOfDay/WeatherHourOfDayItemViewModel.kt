package com.slimshady.weather.ui.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.slimshady.weather.data.remote.model.weather.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherHourOfDayItemViewModel @Inject internal constructor() : ViewModel() {
    var item = ObservableField<ListItem>()
}
