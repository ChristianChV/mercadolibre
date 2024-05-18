package christian.chamorro.search.data.remote.adapters

import christian.chamorro.search.data.remote.dtos.SearchResultDto
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.core.adapters.ToModelAdapter
import javax.inject.Inject

class SearchDtoAdapter @Inject constructor(
    private val searchProductAdapter: SearchProductAdapter
): christian.chamorro.core.adapters.ToModelAdapter<SearchResult, SearchResultDto> {
    override fun toModel(data: SearchResultDto): SearchResult = SearchResult(
        query = data.query,
        totalResults = data.paging.total,
        results = searchProductAdapter.toModelList(data.results)
    )
}