package christian.chamorro.product.domain.usecases

import christian.chamorro.product.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Listen product by id, if it exists return true else false.
 */
class ListenProductFavoriteUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: String): Flow<Boolean> {
        return repository.listenProductFavorite(id)
    }
}