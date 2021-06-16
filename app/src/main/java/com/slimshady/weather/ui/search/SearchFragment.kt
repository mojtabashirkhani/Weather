package com.slimshady.weather.ui.search

import android.annotation.SuppressLint
import android.util.Log
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

        mViewDataBinding.viewModel?.setSearchParams(SearchUseCase.SearchParams("خرم", "city",  isNetworkAvailable(requireContext())))

        mViewDataBinding.viewModel?.getSearchViewState()?.observe(this){
            Log.d("search", it.data.toString())

        }
    }
}