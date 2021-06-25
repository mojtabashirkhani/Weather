package com.slimshady.weather.ui.search.result

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.slimshady.weather.data.local.db.model.MapEntity
import javax.inject.Inject

class SearchResultViewModel @Inject constructor(): ViewModel() {
    var item = ObservableField<MapEntity>()

}