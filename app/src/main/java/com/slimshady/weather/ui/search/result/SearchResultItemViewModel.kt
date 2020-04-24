package com.slimshady.weather.ui.search.result

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import javax.inject.Inject

/**
 * Created by Furkan on 2019-11-04
 */

class SearchResultItemViewModel @Inject internal constructor() : ViewModel() {
    var item = ObservableField<CitiesForSearchEntity>()
}
