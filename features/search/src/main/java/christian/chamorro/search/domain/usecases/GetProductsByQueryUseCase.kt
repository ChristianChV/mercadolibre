package christian.chamorro.search.domain.usecases

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.domain.repositories.SearchRepository
import javax.inject.Inject

class GetProductsByQueryUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String): AsyncResult<SearchResult, NetworkErrors>{
        return repository.getProductsByQuery(query)
    }
}