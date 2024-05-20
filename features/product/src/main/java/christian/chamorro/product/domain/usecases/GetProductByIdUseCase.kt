package christian.chamorro.product.domain.usecases

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.domain.repositories.ProductRepository
import javax.inject.Inject

/**
 * Get product by id from remote source.
 */
class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: String): AsyncResult<Product, NetworkErrors> {
        return repository.getProductById(id)
    }
}