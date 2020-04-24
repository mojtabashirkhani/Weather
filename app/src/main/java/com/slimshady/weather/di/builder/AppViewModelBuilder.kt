package com.slimshady.weather.di.builder

import androidx.lifecycle.ViewModel
import com.slimshady.weather.di.qualifier.ViewModelKey
import com.slimshady.weather.ui.home.HomeViewModel
import com.slimshady.weather.ui.search.SearchViewModel
import com.slimshady.weather.ui.search.result.SearchResultItemViewModel
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
    abstract fun bindSearchViewwModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchResultItemViewModel::class)
    abstract fun bindSearchResultItemViewwModel(searchResultItemViewModel: SearchResultItemViewModel): ViewModel


}