package christian.chamorro.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.search.domain.usecases.DeleteQueryUseCase
import christian.chamorro.search.domain.usecases.GetProductsByQueryUseCase
import christian.chamorro.search.domain.usecases.GetQueriesUseCase
import christian.chamorro.search.presentation.models.SearchActivePage
import christian.chamorro.search.presentation.models.SearchActivePage.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchPageViewModel @Inject constructor(
    private val getProductsByQueryUseCase: GetProductsByQueryUseCase,
    private val getQueriesUseCase: GetQueriesUseCase,
    private val deleteQueryUseCase: DeleteQueryUseCase
) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchPageState())
    val searchState: StateFlow<SearchPageState> = _searchState

    private val _searchQueryState = MutableStateFlow(SearchQueryState())
    val queryState: StateFlow<SearchQueryState> = _searchQueryState


    fun onEvent(event: SearchPageEvent) {
        when (event) {
            SearchPageEvent.GetQueries -> getQueries()
            is SearchPageEvent.DeleteQuery -> deleteQuery(event.query)
            is SearchPageEvent.GetProductsByQuery -> getProductsByQuery(event.query)
            is SearchPageEvent.SetActivePage -> setActivePage(event.page)
        }
    }

    private fun setActivePage(page: SearchActivePage){
        _searchState.update { it.copy(activePage = page) }
    }

    private fun getQueries() = viewModelScope.launch {
        _searchQueryState.update { it.copy(isQueriesLoading = true) }
        getQueriesUseCase().collect { queries ->
            _searchQueryState.update {
                it.copy(isQueriesLoading = false, queriesContent = queries)
            }
        }
    }

    private fun deleteQuery(query: String) = viewModelScope.launch {
        deleteQueryUseCase(query)
    }

    private fun getProductsByQuery(query: String) = viewModelScope.launch {
        _searchState.update {
            it.copy(
                isSearchLoading = true,
                isSearchBarActive = false,
                activePage = Result
            )
        }

        val result = getProductsByQueryUseCase(query)

        when (result) {
            is AsyncResult.Failure -> {
                _searchState.update {
                    it.copy(
                        isSearchLoading = false,
                        isSearchError = result.error,
                        isSearchBarActive = true
                    )
                }
            }

            is AsyncResult.Success -> {
                _searchState.update {
                    it.copy(
                        isSearchLoading = false,
                        searchContent = result.value,
                        isSearchBarActive = false
                    )
                }
            }
        }
    }
}