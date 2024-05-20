package christian.chamorro.product.domain.usecases

import christian.chamorro.product.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListenProductFavoriteUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: String): Flow<Boolean> {
        return repository.listenProductFavorite(id)
    }
}