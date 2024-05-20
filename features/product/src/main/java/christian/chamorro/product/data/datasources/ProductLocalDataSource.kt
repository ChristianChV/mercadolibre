package christian.chamorro.product.data.datasources

import christian.chamorro.product.domain.models.Product
import kotlinx.coroutines.flow.Flow

/**
 * Local data source for favorite products management.
 */
interface ProductLocalDataSource {
    /**
     * Adds a favorite product.
     */
    suspend fun addFavorite(product: Product)

    /**
     * Remove a favorite product.
     */
    suspend fun removeFavorite(product: Product)

    /**
     * Returns all favorite products.
     */
    suspend fun getFavorites(): List<Product>

    /**
     * Listen a product and return a true if it is on favorites otherwise false.
     */
    suspend fun listenProductFavorite(id: String): Flow<Boolean>
}
