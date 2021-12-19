package com.slimshady.weather.ui.weather_detail

import android.os.Build
import android.transition.TransitionInflater
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.data.remote.model.weather.ListItem
import com.slimshady.weather.databinding.FragmentWeatherDetailBinding
import com.slimshady.weather.ui.weather_detail.weatherHourOfDay.WeatherHourOfDayAdapter
import com.slimshady.weather.util.extensions.observeWith
import io.reactivex.disposables.CompositeDisposable

class WeatherDetailFragment : BaseFragment<WeatherDetailViewModel, FragmentWeatherDetailBinding>(R.layout.fragment_weather_detail, WeatherDetailViewModel::class.java) {

    private val weatherDetailFragmentArgs: WeatherDetailFragmentArgs by navArgs()
    var disposable = CompositeDisposable()

    override fun initViews() {
        mViewDataBinding.viewModel?.weatherItem?.set(weatherDetailFragmentArgs.weatherItem)
        mViewDataBinding.viewModel?.selectedDayDate = weatherDetailFragmentArgs.weatherItem?.dtTxt?.substringBefore(" ")

        mViewDataBinding.viewModel?.getForecast()?.observeWith(viewLifecycleOwner) {
            mViewDataBinding.viewModel?.selectedDayForecastLiveData
                ?.postValue(
                    it.list?.filter { item ->
                        item.dtTxt?.substringBefore(" ") == mViewDataBinding.viewModel?.selectedDayDate
                    }
                )
        }

        mViewDataBinding.viewModel?.selectedDayForecastLiveData?.observeWith(
            viewLifecycleOwner
        ) {
            initWeatherHourOfDayAdapter(it)
        }

        mViewDataBinding.fabClose.setOnClickListener {
            findNavController().popBackStack()
        }

        val inflateTransition =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
        sharedElementEnterTransition = inflateTransition
    }

    private fun initWeatherHourOfDayAdapter(list: List<ListItem>) {
        val adapter = WeatherHourOfDayAdapter { item ->
            // TODO - onClick
        }

        mViewDataBinding.recyclerViewHourOfDay.adapter = adapter
        (mViewDataBinding.recyclerViewHourOfDay.adapter as WeatherHourOfDayAdapter).submitList(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}
