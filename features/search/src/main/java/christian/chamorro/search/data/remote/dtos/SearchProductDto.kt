package christian.chamorro.search.data.remote.dtos

data class SearchProductDto(
    val id: String,
    val title: String,
    val permalink: String,
    val thumbnail: String,
    val originalPrice: Long,
    val availableQuantity: Int,
)
