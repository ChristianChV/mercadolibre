package christian.chamorro.search.domain.models

data class Search(
    val query: String,
    val totalResults: Long,
    val results: List<SearchProduct>
)
