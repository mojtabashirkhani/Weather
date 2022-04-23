package com.slimshady.weather.ui.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashFragmentViewModel @Inject constructor() : ViewModel() {
    var navigateDashboard = false
}
