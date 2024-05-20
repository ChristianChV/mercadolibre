package christian.chamorro.search.domain.models

data class SearchProduct(
    val id: String,
    val title: String,
    val permalink: String,
    val thumbnail: String,
    val price: Double,
    val availableQuantity: Int,
)
