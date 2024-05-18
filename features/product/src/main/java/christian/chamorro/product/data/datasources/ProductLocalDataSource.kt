package christian.chamorro.product.data.datasources

import christian.chamorro.product.domain.models.Product

interface ProductLocalDataSource {

    suspend fun addFavorite(product: Product)

    suspend fun removeFavorite(product: Product)

    suspend fun getFavorites(): List<Product>
}