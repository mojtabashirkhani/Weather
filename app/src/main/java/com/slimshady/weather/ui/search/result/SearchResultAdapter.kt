package com.slimshady.weather.ui.search.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.slimshady.weather.base.BaseAdapter
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.data.remote.model.places_response.Value
import com.slimshady.weather.databinding.ItemSearchBinding


class SearchResultAdapter(private val callBack: (Value) -> Unit) : BaseAdapter<Value>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemSearchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewModel = SearchResultViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                callBack.invoke(it)
            }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemSearchBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<Value>() {
    override fun areContentsTheSame(oldItem: Value, newItem: Value): Boolean =
        oldItem.geom == newItem.geom

    override fun areItemsTheSame(oldItem: Value, newItem: Value): Boolean =
        oldItem.geom == newItem.geom
}
