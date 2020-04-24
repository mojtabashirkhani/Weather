package com.slimshady.weather.data.remote.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import com.slimshady.weather.repo.SearchCitiesRepository
import com.slimshady.weather.ui.search.SearchViewState
import com.slimshady.weather.util.UseCaseLiveData
import com.slimshady.weather.util.domain.Resource
import javax.inject.Inject

/**
 * Created by Furkan on 2019-10-31
 */

class SearchCitiesUseCase @Inject internal constructor(private val repository: SearchCitiesRepository) : UseCaseLiveData<SearchViewState, SearchCitiesUseCase.SearchCitiesParams, SearchCitiesRepository>() {

    override fun getRepository(): SearchCitiesRepository = repository

    override fun buildUseCaseObservable(params: SearchCitiesParams?): LiveData<SearchViewState> {
        return repository.loadCitiesByCityName(
            cityName = params?.city ?: ""
        ).map {
            onSearchResultReady(it)
        }
    }

    private fun onSearchResultReady(resource: Resource<List<CitiesForSearchEntity>>): SearchViewState {
        return SearchViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class SearchCitiesParams(
        val city: String = ""
    ) : Params()
}
