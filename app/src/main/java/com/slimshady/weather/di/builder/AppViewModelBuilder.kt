package com.slimshady.weather.di.builder

import androidx.lifecycle.ViewModel
import com.slimshady.weather.di.qualifier.ViewModelKey
import com.slimshady.weather.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel


}