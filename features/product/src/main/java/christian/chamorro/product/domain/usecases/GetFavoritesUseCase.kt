package christian.chamorro.product.domain.usecases

import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.domain.repositories.ProductRepository
import javax.inject.Inject

/**
 * Get all favorites products.
 */
class GetFavoritesUseCase
    @Inject
    constructor(
        private val repository: ProductRepository,
    ) {
        suspend operator fun invoke(): List<Product> {
            return repository.getFavorites()
        }
    }
