package christian.chamorro.product.data.datasources

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product

interface ProductRemoteDataSource {
    suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors>
}