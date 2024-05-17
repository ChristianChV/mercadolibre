package christian.chamorro.search.data.remote.dtos

import christian.chamorro.search.domain.models.SearchProduct

data class SearchDto(
    val query: String,
    val paging: PagingDto,
    val results: List<SearchProductDto>
)
