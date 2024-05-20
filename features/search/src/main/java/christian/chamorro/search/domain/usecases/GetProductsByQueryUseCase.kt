package christian.chamorro.search.domain.usecases

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.domain.repositories.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Get products by query from remote resource.
 */
class GetProductsByQueryUseCase
@Inject
constructor(
    private val repository: SearchRepository,
) {
    suspend operator fun invoke(query: String): AsyncResult<SearchResult, NetworkErrors> =
        withContext(Dispatchers.IO) {
            return@withContext repository.getProductsByQuery(query)
        }
}
