package com.slimshady.weather.ui.home

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.*
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.transition.TransitionInflater
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.slimshady.weather.MainActivity
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.base.BasePermissionModel
import com.slimshady.weather.core.Constants
import com.slimshady.weather.data.remote.model.weather.ListItem
import com.slimshady.weather.data.remote.usecase.CurrentWeatherUseCase
import com.slimshady.weather.data.remote.usecase.ForecastUseCase
import com.slimshady.weather.databinding.FragmentHomeBinding
import com.slimshady.weather.service.ForegroundOnlyLocationService
import com.slimshady.weather.ui.home.forecast.ForecastAdapter
import com.slimshady.weather.util.SharedPreferenceUtil
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.observeWith
import com.slimshady.weather.util.toText
import kotlinx.android.synthetic.main.app_bar_main.view.*
import kotlinx.android.synthetic.main.fragment_home.*

private const val TAG = "HomeFragment"
private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34



class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
), SharedPreferences.OnSharedPreferenceChangeListener {

    val args : HomeFragmentArgs by navArgs()

    private var foregroundOnlyLocationServiceBound = false

    // Provides location updates for while-in-use feature.
    private var foregroundOnlyLocationService: ForegroundOnlyLocationService? = null

    // Listens for location broadcasts from ForegroundOnlyLocationService.
    private lateinit var foregroundOnlyBroadcastReceiver: ForegroundOnlyBroadcastReceiver

    private lateinit var sharedPreferences: SharedPreferences

//    private lateinit var foregroundOnlyLocationButton: Button

    private val foregroundOnlyServiceConnection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val binder = service as ForegroundOnlyLocationService.LocalBinder
            foregroundOnlyLocationService = binder.service
            foregroundOnlyLocationServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            foregroundOnlyLocationService = null
            foregroundOnlyLocationServiceBound = false
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("LogNotTimber")
    override fun initViews() {

        val lon = args.geom?.coordinates?.get(0)
        val lat = args.geom?.coordinates?.get(1)

        foregroundOnlyBroadcastReceiver = ForegroundOnlyBroadcastReceiver()

        sharedPreferences =
            requireActivity().getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE
            )

       /* foregroundOnlyLocationButton = findViewById(R.id.foreground_only_location_button)
        outputTextView = findViewById(R.id.output_text_view)
*/
      /*  foregroundOnlyLocationButton.setOnClickListener {
            val enabled = sharedPreferences.getBoolean(
                SharedPreferenceUtil.KEY_FOREGROUND_ENABLED, false
            )

            if (enabled) {
                foregroundOnlyLocationService?.unsubscribeToLocationUpdates()
            } else {

                // TODO: Step 1.0, Review Permissions: Checks and requests if needed.

                checkPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)){

                }
               *//* if (foregroundPermissionApproved()) {
                    foregroundOnlyLocationService?.subscribeToLocationUpdates()
                        ?: Log.d(TAG, "Service Not Bound")
                } else {
                    requestForegroundPermissions()
                }*//*
            }
        }*/



        initForecastAdapter()


//        val args: HomeFragmentArgs = HomeFragmentArgs.fromBundle(arguments?: Bundle())

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
            /*  val action = DashboardFragmentDirections.actionDashboardFragmentToWeatherDetailFragment(item)
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
                  )*/
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

    private inner class ForegroundOnlyBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val location = intent.getParcelableExtra<Location>(
                ForegroundOnlyLocationService.EXTRA_LOCATION
            )

            if (location != null) {
                Log.d("Foreground location:", location.toText())
            }
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        if (key == SharedPreferenceUtil.KEY_FOREGROUND_ENABLED) {
           /* updateButtonState(sharedPreferences.getBoolean(
                SharedPreferenceUtil.KEY_FOREGROUND_ENABLED, false)
            )*/
        }
    }

    override fun onStart() {
        super.onStart()

        sharedPreferences.registerOnSharedPreferenceChangeListener(this)


        val serviceIntent = Intent(context, ForegroundOnlyLocationService::class.java)
        requireActivity().bindService(serviceIntent, foregroundOnlyServiceConnection, Context.BIND_AUTO_CREATE)
    }


    override fun onResume() {
        super.onResume()
        context?.let {
            LocalBroadcastManager.getInstance(it).registerReceiver(
                foregroundOnlyBroadcastReceiver,
                IntentFilter(
                    ForegroundOnlyLocationService.ACTION_FOREGROUND_ONLY_LOCATION_BROADCAST)
            )
        }
    }

    override fun onPause() {
        context?.let {
            LocalBroadcastManager.getInstance(it).unregisterReceiver(
                foregroundOnlyBroadcastReceiver
            )
        }
        super.onPause()
    }

    override fun onStop() {
        if (foregroundOnlyLocationServiceBound) {
            requireActivity().unbindService(foregroundOnlyServiceConnection)
            foregroundOnlyLocationServiceBound = false
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)

        super.onStop()
    }


}
