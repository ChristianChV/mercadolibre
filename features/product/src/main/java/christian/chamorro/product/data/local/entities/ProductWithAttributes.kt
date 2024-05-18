package christian.chamorro.product.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithAttributes(
    @Embedded val product: ProductEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "productId"
    )
    val attributes: List<AttributeEntity>
)
