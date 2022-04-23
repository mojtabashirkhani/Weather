package com.slimshady.weather.ui.search.result

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.slimshady.weather.data.remote.model.places_response.Value
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(): ViewModel() {
    var item = ObservableField<Value>()

}