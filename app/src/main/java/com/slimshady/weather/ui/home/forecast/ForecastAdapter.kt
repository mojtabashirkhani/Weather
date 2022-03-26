package com.slimshady.weather.ui.home.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseAdapter
import com.slimshady.weather.data.remote.model.weather.ListItem
import com.slimshady.weather.databinding.ItemForecastBinding

/**
 * Created by Furkan on 2019-10-25
 */

class ForecastAdapter(private val callBack: (ListItem, View, View, View, View, View) -> Unit) : BaseAdapter<ListItem>(
    diffCallback
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewModel = ForecastItemViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                ViewCompat.setTransitionName(mBinding.cardView, mBinding.rootView.resources.getString(
                    R.string.cardView, it.getDay()))
                ViewCompat.setTransitionName(mBinding.imageViewForecastIcon, mBinding.rootView.resources.getString(R.string.forecastIcon, it.getDay()))
                ViewCompat.setTransitionName(mBinding.textViewDayOfWeek, mBinding.rootView.resources.getString(R.string.dayOfWeek, it.getDay()))
                ViewCompat.setTransitionName(mBinding.textViewTemp, mBinding.rootView.resources.getString(R.string.temp, it.getDay()))
                ViewCompat.setTransitionName(mBinding.linearLayoutTempMaxMin, mBinding.rootView.resources.getString(R.string.tempMaxMin, it.getDay()))

                callBack.invoke(
                    it,
                    mBinding.cardView,
                    mBinding.imageViewForecastIcon,
                    mBinding.textViewDayOfWeek,
                    mBinding.textViewTemp,
                    mBinding.linearLayoutTempMaxMin
                )
            }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemForecastBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<ListItem>() {
    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.dtTxt == newItem.dtTxt
}
