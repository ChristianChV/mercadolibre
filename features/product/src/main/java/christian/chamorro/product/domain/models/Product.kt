package christian.chamorro.product.domain.models

data class Product(
    val id: String,
    val title: String,
    val condition: String,
    val thumbnail: String,
    val originalPrice: Long,
    val initialQuantity: Long,
    val acceptsMercadopago: Boolean,
    val warranty: String,
    val attributes: List<Attribute>,
    val pictures: List<String>,
)
