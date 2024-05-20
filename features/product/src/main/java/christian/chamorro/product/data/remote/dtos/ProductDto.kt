package christian.chamorro.product.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**
 * Product data access object.
 */
data class ProductDto(
    val id: String,
    val title: String,
    val condition: String,
    val thumbnail: String,
    val price: Double,
    @SerializedName("initial_quantity")
    val initialQuantity: Long,
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    val warranty: String?,
    val attributes: List<AttributeDto>,
    val pictures: List<PictureDto>,
)
