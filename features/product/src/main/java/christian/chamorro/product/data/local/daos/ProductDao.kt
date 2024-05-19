package christian.chamorro.product.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.data.local.entities.ProductEntity
import christian.chamorro.product.data.local.entities.ProductWithAttributes
import retrofit2.http.DELETE

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProductAndAttributes(
        product: ProductEntity,
        attributes: List<AttributeEntity>
    )

    @Delete
    suspend fun removeFromFavorites(product: ProductEntity)

    @Transaction
    @Query("SELECT * FROM product")
    suspend fun getFavorites(): List<ProductWithAttributes>
}