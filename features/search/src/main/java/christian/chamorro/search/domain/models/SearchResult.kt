package christian.chamorro.search.domain.models

data class SearchResult(
    val query: String,
    val totalResults: Long,
    val results: List<SearchProduct>,
)
