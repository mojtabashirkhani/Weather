package com.slimshady.weather.data.remote.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.repo.MapRepository
import com.slimshady.weather.ui.search.SearchViewState
import com.slimshady.weather.util.UseCaseLiveData
import com.slimshady.weather.util.domain.Resource
import javax.inject.Inject

class SearchUseCase @Inject internal constructor(private val repository: MapRepository):
    UseCaseLiveData<SearchViewState, SearchUseCase.SearchParams, MapRepository>() {

    override fun getRepository(): MapRepository {
        return repository
    }


    override fun buildUseCaseObservable(params: SearchParams?): LiveData<SearchViewState> {
        return repository.loadCitiesByCityName(params?.text ?: "", params?.select ?:  "", params?.fetchRequired ?: false).map {
            onSearchResultReady(it)
        }
    }

    private fun onSearchResultReady(resource: Resource<MapEntity>): SearchViewState {
        return SearchViewState(status = resource.status, error = resource.message, data = resource.data)
    }

    class SearchParams(
        val text: String = "",
        val select: String = "",
        val fetchRequired: Boolean

        ) : UseCaseLiveData.Params()

}