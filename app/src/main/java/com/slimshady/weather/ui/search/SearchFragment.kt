package com.slimshady.weather.ui.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.data.remote.usecase.SearchUseCase
import com.slimshady.weather.databinding.FragmentSearchBinding
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.observeWith

class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>(R.layout.fragment_search, SearchViewModel::class.java) {
    @SuppressLint("LogNotTimber")
    override fun initViews() {

        mViewDataBinding.viewModel?.setSearchParams(SearchUseCase.SearchParams("تهران", "city",  isNetworkAvailable(requireContext())))

        mViewDataBinding.viewModel?.getSearchViewState()?.observe(this){
            Log.d("search", it.data.toString())

            if (it.data != null) {
                val action = SearchFragmentDirections.actionNavSearchToNavHome(it.data.value[0].geom.coordinates[0].toString(),
                    it.data.value[0].geom.coordinates[1].toString())
                navigate(action)
            }
        }
    }
}