package christian.chamorro.product.domain.repositories

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product
import kotlinx.coroutines.flow.Flow

/**
 * Repository to manage product resources.
 */
interface ProductRepository {
    /**
     * Get product by id from remote resource.
     * @param id: Product identifier
     */
    suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors>

    /**
     * Add product to favorites.
     */
    suspend fun addToFavorites(product: Product)

    /**
     * Remove product from favorites.
     */
    suspend fun removeFromFavorites(product: Product)

    /**
     * Get all favorites products.
     */
    suspend fun getFavorites(): List<Product>

    /**
     * Listen product by id, if it exists return true else false.
     */
    suspend fun listenProductFavorite(id: String): Flow<Boolean>
}
