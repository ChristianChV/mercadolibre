package christian.chamorro.search.presentation

import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.presentation.models.SearchActivePage

data class SearchPageState(
    val isSearchLoading: Boolean = false,
    val searchContent: SearchResult ? = null,
    val isSearchError: NetworkErrors? = null,
    val activePage: SearchActivePage = SearchActivePage.Queries,
    val isSearchBarActive: Boolean = true
)
