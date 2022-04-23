package com.slimshady.weather.ui.search

import android.annotation.SuppressLint
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.slimshady.weather.R
import com.slimshady.weather.base.BaseFragment
import com.slimshady.weather.data.remote.model.places_response.Value
import com.slimshady.weather.data.remote.usecase.SearchUseCase
import com.slimshady.weather.databinding.FragmentSearchBinding
import com.slimshady.weather.ui.search.result.SearchResultAdapter
import com.slimshady.weather.util.extensions.isNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(
    R.layout.fragment_search,
    SearchViewModel::class.java
) {
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
        mViewDataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String?): Boolean {
                if (newText?.isNotEmpty() == true && newText.count() > 2) {
                    mViewDataBinding.viewModel?.setSearchParams(
                        SearchUseCase.SearchParams(
                            newText,
                            "city",
                            isNetworkAvailable(context ?: requireContext())
                        )
                    )
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isNotEmpty() == true && newText.count() > 2) {
                    mViewDataBinding.viewModel?.setSearchParams(
                        SearchUseCase.SearchParams(
                            newText, "city", isNetworkAvailable(
                                context ?: requireContext()
                            )
                        )
                    )
                }
                return true
            }

        })
    }


    private fun initSearchResultsAdapter() {
        val adapter = SearchResultAdapter { item ->
            val action =SearchFragmentDirections.actionNavSearchToNavHome(item.geom)
            findNavController().navigate(action)

            /* item.coord?.let {
                 binding.viewModel?.saveCoordsToSharedPref(it)
                     ?.subscribe { _, _ ->

                         tryCatch(
                             tryBlock = {
                                 binding.searchView.hideKeyboard((activity as MainActivity))
                             }
                         )

                     }
             }*/
        }

        mViewDataBinding.recyclerSearch.adapter = adapter
        mViewDataBinding.recyclerSearch.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
       /* val decorator = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.divider) }!!)
        mViewDataBinding.recyclerSearch.addItemDecoration(decorator)*/
    }


    private fun initSearchResultsRecyclerView(results: List<Value>?) {
        val newResults = results?.distinctBy { it.city }
        (mViewDataBinding.recyclerSearch.adapter as? SearchResultAdapter)?.submitList(newResults)

    }
}




