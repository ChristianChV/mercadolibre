package christian.chamorro.search.data.remote.adapters

import christian.chamorro.search.data.remote.dtos.SearchDto
import christian.chamorro.search.domain.models.Search
import christian.chamorro.uicomponents.adapters.ToModelAdapter
import javax.inject.Inject

class SearchDtoAdapter @Inject constructor(
    private val searchProductAdapter: SearchProductAdapter
): ToModelAdapter<Search, SearchDto> {
    override fun toModel(data: SearchDto): Search = Search(
        query = data.query,
        totalResults = data.paging.total,
        results = searchProductAdapter.toModelList(data.results)
    )
}