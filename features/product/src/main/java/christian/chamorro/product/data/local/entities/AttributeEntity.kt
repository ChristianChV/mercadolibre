package christian.chamorro.product.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Attribute entity class.
 */
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
    val id: Long? = null,
    @ColumnInfo(index = true)
    val productId: String,
    val name: String,
    val valueName: String?,
)
