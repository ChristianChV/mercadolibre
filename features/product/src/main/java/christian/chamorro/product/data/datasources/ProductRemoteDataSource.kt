package christian.chamorro.product.data.datasources

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product

/**
 * Remote data source to manage products.
 */
interface ProductRemoteDataSource {
    /**
     * Function get a product by id.
     * @param id: product identifier
     * @return AsyncResult to handle success and failure result
     */
    suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors>
}
