package christian.chamorro.product.domain.models

data class Product(
    val id: String,
    val title: String,
    val condition: String,
    val thumbnailId: String,
    val permalink: String,
    val thumbnail: String,
    val originalPrice: Long,
    val availableQuantity: Int,
    val officialStoreName: String,
    val acceptsMercadopago: Boolean,
    val seller: Seller,
    val attributes: List<Attribute>,
    val pictures: List<String>
)
