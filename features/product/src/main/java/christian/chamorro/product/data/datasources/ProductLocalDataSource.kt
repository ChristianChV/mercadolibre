package christian.chamorro.product.data.datasources

import christian.chamorro.product.domain.models.Product

interface ProductLocalDataSource {

    suspend fun addToFavorites(product: Product)

    suspend fun removeFromFavorites(product: Product)

    suspend fun getFavorites(): List<Product>
}