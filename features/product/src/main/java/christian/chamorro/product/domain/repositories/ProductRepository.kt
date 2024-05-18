package christian.chamorro.product.domain.repositories

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product

interface ProductRepository {

    suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors>

    suspend fun addToFavorites(product: Product)

    suspend fun removeFromFavorites(product: Product)

    suspend fun getFavorites(): List<Product>
}