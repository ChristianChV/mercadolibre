package christian.chamorro.product.data

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.data.datasources.ProductLocalDataSource
import christian.chamorro.product.data.datasources.ProductRemoteDataSource
import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl
    @Inject
    constructor(
        private val local: ProductLocalDataSource,
        private val remote: ProductRemoteDataSource,
    ) : ProductRepository {
        override suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors> {
            return remote.getProductById(id)
        }

        override suspend fun addToFavorites(product: Product) {
            local.addFavorite(product)
        }

        override suspend fun removeFromFavorites(product: Product) {
            local.removeFavorite(product)
        }

        override suspend fun getFavorites(): List<Product> {
            return local.getFavorites()
        }

        override suspend fun listenProductFavorite(id: String): Flow<Boolean> {
            return local.listenProductFavorite(id)
        }
    }
