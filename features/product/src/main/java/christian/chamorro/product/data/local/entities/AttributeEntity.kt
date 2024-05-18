package christian.chamorro.product.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "attribute", foreignKeys = [
    ForeignKey(
        entity = ProductEntity::class,
        parentColumns = ["id"],
        childColumns = ["productId"],
        onDelete = ForeignKey.CASCADE
    )
])
data class AttributeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String? = null,
    val productId: String,
    val name: String,
    val valueName: String,
)
