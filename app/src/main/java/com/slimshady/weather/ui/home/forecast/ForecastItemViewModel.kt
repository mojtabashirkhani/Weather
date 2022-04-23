package com.slimshady.weather.ui.home.forecast

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.slimshady.weather.base.BaseViewModel
import com.slimshady.weather.data.remote.model.weather.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ForecastItemViewModel @Inject internal constructor() : ViewModel() {
    var item = ObservableField<ListItem>()
}
