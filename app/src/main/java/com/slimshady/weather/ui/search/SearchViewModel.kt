package com.slimshady.weather.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.slimshady.weather.data.remote.usecase.SearchUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase): ViewModel() {

    private val _searchParams = MutableLiveData<SearchUseCase.SearchParams>()

    fun getSearchViewState() = searchViewState

    private val searchViewState = _searchParams.switchMap {
        searchUseCase.execute(it)
    }

    fun setSearchParams(params: SearchUseCase.SearchParams) {
        if (_searchParams.value == params){
            _searchParams.postValue(params)
        }
    }
}