package christian.chamorro.search.data.remote.dtos

/**
 * SearchResult data access object.
 */
data class SearchResultDto(
    val query: String,
    val paging: PagingDto,
    val results: List<SearchProductDto>,
)
