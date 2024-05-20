package christian.chamorro.product.data.remote.dtos

import christian.chamorro.product.domain.models.Attribute
import com.google.gson.annotations.SerializedName

/**
 * Product data access object.
 */
data class ProductDto(
    val id: String,
    val title: String,
    val condition: String,
    val thumbnail: String,
    @SerializedName("original_price")
    val originalPrice: Double,
    @SerializedName("initial_quantity")
    val initialQuantity: Long,
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    val warranty: String?,
    val attributes: List<AttributeDto>,
    val pictures: List<PictureDto>,
)