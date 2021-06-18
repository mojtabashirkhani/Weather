package com.slimshady.weather.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.navArgs
import com.slimshady.weather.MainActivity
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.remote.usecase.CurrentWeatherUseCase
import com.slimshady.weather.data.remote.usecase.ForecastUseCase
import com.slimshady.weather.databinding.FragmentHomeBinding
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.observeWith
import kotlinx.android.synthetic.main.app_bar_main.view.*

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {


    @SuppressLint("LogNotTimber")
    override fun initViews() {


        val args: HomeFragmentArgs = HomeFragmentArgs.fromBundle(arguments?: Bundle())

        mViewDataBinding.viewModel?.setCurrentWeatherParams(
            CurrentWeatherUseCase.CurrentWeatherParams(
                args.lat ,
                args.lon ,
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.setForecastParams(
            ForecastUseCase.ForecastParams(
                args.lat ,
                args.lon ,
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.getForecastViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            Log.d("forecast_weather", it.data?.list.toString())
        }

        mViewDataBinding.viewModel?.getCurrentWeatherViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            Log.d("current_weather", it.data.toString())
        }
        
    }


}
