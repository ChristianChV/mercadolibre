package christian.chamorro.search.domain.usecases

import christian.chamorro.search.domain.repositories.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQueriesUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(): Flow<List<String>>{
        return repository.getQueries()
    }
}