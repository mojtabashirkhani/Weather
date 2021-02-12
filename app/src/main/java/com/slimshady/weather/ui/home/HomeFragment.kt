package com.slimshady.weather.ui.home

import android.annotation.SuppressLint
import android.util.Log
import com.slimshady.weather.MainActivity
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.remote.usecase.CurrentWeatherUseCase
import com.slimshady.weather.data.remote.usecase.ForecastUseCase
import com.slimshady.weather.databinding.FragmentHomeBinding
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.observeWith

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {


    @SuppressLint("LogNotTimber")
    override fun initViews() {
        mViewDataBinding.viewModel?.setCurrentWeatherParams(
            CurrentWeatherUseCase.CurrentWeatherParams(
                "40.7127",
                "-74.006",
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.setForecastParams(
            ForecastUseCase.ForecastParams(
                "40.7127",
                "-74.006",
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.getForecastViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            with(mViewDataBinding) {
                Log.d("forecast_weather", it.data?.list.toString())

            }
        }

        mViewDataBinding.viewModel?.getCurrentWeatherViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            with(mViewDataBinding) {
                Log.d("current_weather", it.data.toString())
            }
        }
    }


}
