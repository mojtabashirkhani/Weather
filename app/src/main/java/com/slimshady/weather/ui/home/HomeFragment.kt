package com.slimshady.weather.ui.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.remote.model.weather.ListItem
import com.slimshady.weather.data.remote.usecase.CurrentWeatherUseCase
import com.slimshady.weather.data.remote.usecase.ForecastUseCase
import com.slimshady.weather.databinding.FragmentHomeBinding
import com.slimshady.weather.ui.home.forecast.ForecastAdapter
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.observeWith
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
){

    val args : HomeFragmentArgs by navArgs()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("LogNotTimber")
    override fun initViews() {

        val lon = args.geom?.coordinates?.get(0)
        val lat = args.geom?.coordinates?.get(1)

        initForecastAdapter()

        mViewDataBinding.viewModel?.setCurrentWeatherParams(
            CurrentWeatherUseCase.CurrentWeatherParams(
                lat.toString(),
                lon.toString(),
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.setForecastParams(
            ForecastUseCase.ForecastParams(
                lat.toString(),
                lon.toString(),
                isNetworkAvailable(requireContext()),
                Constants.Coords.METRIC
            )
        )

        mViewDataBinding.viewModel?.getForecastViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            it.data?.list?.let { forecasts -> initForecast(forecasts) }
        }

        mViewDataBinding.viewModel?.getCurrentWeatherViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            mViewDataBinding.containerForecast.viewState = it
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initForecastAdapter() {
        val adapter = ForecastAdapter { item, cardView, forecastIcon, dayOfWeek, temp, tempMaxMin ->
              val action = HomeFragmentDirections.actionNavHomeToNavWeatherDetail(item)
              findNavController()
                  .navigate(
                      action,
                      FragmentNavigator.Extras.Builder()
                          .addSharedElements(
                              mapOf(
                                  cardView to cardView.transitionName,
                                  forecastIcon to forecastIcon.transitionName,
                                  dayOfWeek to dayOfWeek.transitionName,
                                  temp to temp.transitionName,
                                  tempMaxMin to tempMaxMin.transitionName
                              )
                          )
                          .build()
                  )
        }

        mViewDataBinding.recyclerForecast.adapter = adapter
        mViewDataBinding.recyclerForecast.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        postponeEnterTransition()
        mViewDataBinding.recyclerForecast.viewTreeObserver
            .addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
    }

    private fun initForecast(list: List<ListItem>?) {
        (mViewDataBinding.recyclerForecast.adapter as ForecastAdapter).submitList(list)
    }


}
