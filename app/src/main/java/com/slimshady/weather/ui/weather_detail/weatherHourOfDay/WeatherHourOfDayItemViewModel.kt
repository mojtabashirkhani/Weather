package com.slimshady.weather.ui.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import com.slimshady.weather.base.BaseViewModel
import com.slimshady.weather.data.remote.model.weather.ListItem
import javax.inject.Inject


class WeatherHourOfDayItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
