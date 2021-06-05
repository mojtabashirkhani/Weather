package com.slimshady.weather.data.remote.usecase

import androidx.lifecycle.LiveData
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.repo.MapRepository
import com.slimshady.weather.ui.search.SearchViewState
import com.slimshady.weather.util.UseCaseLiveData
import com.slimshady.weather.util.domain.Resource
import javax.inject.Inject

class SearchUseCase @Inject internal constructor() {

   /* override fun getRepository(): MapRepository {
        return repository
    }


    override fun buildUseCaseObservable(params: SearchParams?): LiveData<SearchViewState> {
        return repository.loadCitiesByCityName(
            cityName = params?.city ?: ""
        ).map {
            onSearchResultReady(it)
        }
    }

    private fun onSearchResultReady(resource: Resource<MapEntity>): SearchViewState {
        return SearchViewState(status = resource.status, error = resource.message, data = resource.data)
    }

    class SearchParams(
        val city: String = ""
        ) : UseCaseLiveData.Params()*/

}