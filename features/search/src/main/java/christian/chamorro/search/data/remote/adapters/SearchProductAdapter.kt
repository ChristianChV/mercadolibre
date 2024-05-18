package christian.chamorro.search.data.remote.adapters

import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.search.data.remote.dtos.SearchProductDto
import christian.chamorro.search.domain.models.SearchProduct

class SearchProductAdapter :
    christian.chamorro.core.adapters.ToModelAdapter<SearchProduct, SearchProductDto> {
    override fun toModel(data: SearchProductDto): SearchProduct =
        SearchProduct(
            id = data.id,
            title = data.title,
            permalink = data.permalink,
            thumbnail = data.thumbnail,
            originalPrice = data.originalPrice,
            availableQuantity = data.availableQuantity,
        )
}
