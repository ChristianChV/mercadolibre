package christian.chamorro.search.data.remote.adapters

import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.search.data.remote.dtos.SearchResultDto
import christian.chamorro.search.domain.models.SearchResult
import javax.inject.Inject

/**
 * This class adapt SearchResult model to SearchResultDto.
 */
class SearchDtoAdapter
    @Inject
    constructor(
        private val searchProductAdapter: SearchProductAdapter,
    ) : ToModelAdapter<SearchResult, SearchResultDto> {
        override fun toModel(data: SearchResultDto): SearchResult =
            SearchResult(
                query = data.query,
                totalResults = data.paging.total,
                results = searchProductAdapter.toModelList(data.results),
            )
    }
