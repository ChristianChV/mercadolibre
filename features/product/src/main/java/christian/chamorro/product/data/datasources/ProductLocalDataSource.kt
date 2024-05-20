package christian.chamorro.product.data.datasources

import christian.chamorro.product.domain.models.Product
import kotlinx.coroutines.flow.Flow

/**
 * Local data source for favorite products management.
 */
interface ProductLocalDataSource {

    /**
     * Adds a product to local storage.
     */
    suspend fun addFavorite(product: Product)

    suspend fun removeFavorite(product: Product)

    suspend fun getFavorites(): List<Product>

    suspend fun listenProductFavorite(id: String): Flow<Boolean>
}