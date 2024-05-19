package christian.chamorro.search.presentation

data class SearchQueryState(
    val queriesContent: List<String> ? = null,
    val isQueriesLoading: Boolean = false,
)
