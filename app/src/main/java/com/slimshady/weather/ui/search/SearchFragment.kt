package com.slimshady.weather.ui.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.slimshady.weather.MainActivity
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.data.remote.model.places_response.Value
import com.slimshady.weather.data.remote.usecase.SearchUseCase
import com.slimshady.weather.databinding.FragmentSearchBinding
import com.slimshady.weather.ui.search.result.SearchResultAdapter
import com.slimshady.weather.util.extensions.hideKeyboard
import com.slimshady.weather.util.extensions.isNetworkAvailable
import com.slimshady.weather.util.extensions.tryCatch

class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>(R.layout.fragment_search, SearchViewModel::class.java) {
    @SuppressLint("LogNotTimber")
    override fun initViews() {



        initSearchView()
        initSearchResultsAdapter()
        mViewDataBinding.viewModel?.getSearchViewState()?.observe(this) {
            mViewDataBinding.viewState = it
            initSearchResultsRecyclerView(it.data?.value)
        }

    }

    private fun initSearchView() {
        mViewDataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                if (newText?.isNotEmpty() == true && newText.count() > 2) {
                    mViewDataBinding.viewModel?.setSearchParams(SearchUseCase.SearchParams(newText, "city", isNetworkAvailable(context ?: requireContext())))
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isNotEmpty() == true && newText.count() > 2) {
                    mViewDataBinding.viewModel?.setSearchParams(SearchUseCase.SearchParams(newText, "city", isNetworkAvailable(
                        context ?: requireContext()
                    )))
                }
                return true
            }

        })
    }


    private fun initSearchResultsAdapter() {
        val adapter = SearchResultAdapter { item ->
           /* item.coord?.let {
                binding.viewModel?.saveCoordsToSharedPref(it)
                    ?.subscribe { _, _ ->

                        tryCatch(
                            tryBlock = {
                                binding.searchView.hideKeyboard((activity as MainActivity))
                            }
                        )

                        findNavController().navigate(R.id.action_searchFragment_to_dashboardFragment)
                    }
            }*/
        }

        mViewDataBinding.recyclerSearch.adapter = adapter
        mViewDataBinding.recyclerSearch.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }



    private fun initSearchResultsRecyclerView(results: List<Value>?) {
        (mViewDataBinding.recyclerSearch.adapter as? SearchResultAdapter)?.submitList(results)
    }
}




