package christian.chamorro.product.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Product entity class.
 */
@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val condition: String,
    val thumbnail: String,
    val originalPrice: Double,
    val initialQuantity: Long,
    val acceptsMercadopago: Boolean,
    val warranty: String?,
    val pictures: List<String>,
)
