package com.slimshady.weather.data.remote.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.slimshady.weather.data.local.db.model.SearchEntity
import com.slimshady.weather.repo.SearchRepository
import com.slimshady.weather.ui.search.SearchViewState
import com.slimshady.weather.util.UseCaseLiveData
import com.slimshady.weather.util.domain.Resource
import javax.inject.Inject

class SearchUseCase @Inject internal constructor(private val repository: SearchRepository): UseCaseLiveData<SearchViewState, SearchUseCase.SearchParams, SearchRepository>() {

    override fun getRepository(): SearchRepository {
        return repository
    }


    override fun buildUseCaseObservable(params: SearchParams?): LiveData<SearchViewState> {
        return repository.loadCitiesByCityName(
            cityName = params?.city ?: ""
        ).map {
            onSearchResultReady(it)
        }
    }

    private fun onSearchResultReady(resource: Resource<SearchEntity>): SearchViewState {
        return SearchViewState(status = resource.status, error = resource.message, data = resource.data)
    }

    class SearchParams(
        val city: String = ""
        ) : UseCaseLiveData.Params()

}