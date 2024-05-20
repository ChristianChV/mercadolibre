package christian.chamorro.search.presentation

import christian.chamorro.search.presentation.models.SearchActivePage

sealed class SearchPageEvent {
    object GetQueries : SearchPageEvent()

    data class DeleteQuery(val query: String) : SearchPageEvent()

    data class GetProductsByQuery(val query: String) : SearchPageEvent()

    data class SetActivePage(val page: SearchActivePage) : SearchPageEvent()
}
