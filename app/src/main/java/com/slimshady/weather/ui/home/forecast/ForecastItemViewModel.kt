package com.slimshady.weather.ui.home.forecast

import androidx.databinding.ObservableField
import com.slimshady.weather.base.BaseViewModel
import com.slimshady.weather.data.remote.model.weather.ListItem
import javax.inject.Inject



class ForecastItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
