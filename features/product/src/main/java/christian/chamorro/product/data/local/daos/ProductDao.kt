package christian.chamorro.product.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.data.local.entities.ProductEntity
import christian.chamorro.product.data.local.entities.ProductWithAttributes
import kotlinx.coroutines.flow.Flow

/**
 * Data access object to manage local product and attributes storing.
 */
@Dao
interface ProductDao {

    /**
     * Store locally favorite product.
     * @param product: Product entity
     * @param attributes: List of attributes in one product
     */
    @Insert
    suspend fun insertProductAndAttributes(
        product: ProductEntity,
        attributes: List<AttributeEntity>
    )

    /**
     * Delete ProductEntity from favorites.
     */
    @Delete
    suspend fun removeFromFavorites(product: ProductEntity)

    /**
     * Get locally stored favorites.
     * @return list of intermediate class ProductWithAttributes which relates Product entity with list of AttributeEntity
     */
    @Transaction
    @Query("SELECT * FROM product")
    suspend fun getFavorites(): List<ProductWithAttributes>

    /**
     * Listen product by id, emit a flow with product if it exists else null.
     * @param id: product identifier
     */
    @Query("SELECT * FROM product WHERE id = :id")
    fun listenProductById(id: String): Flow<ProductEntity?>
}