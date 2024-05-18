package christian.chamorro.search.data.remote.dtos

data class SearchResultDto(
    val query: String,
    val paging: PagingDto,
    val results: List<SearchProductDto>
)
