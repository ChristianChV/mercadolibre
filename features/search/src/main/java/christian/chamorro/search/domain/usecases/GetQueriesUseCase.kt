package christian.chamorro.search.domain.usecases

import christian.chamorro.search.domain.repositories.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Get all queries in storage
 */
class GetQueriesUseCase
    @Inject
    constructor(
        private val repository: SearchRepository,
    ) {
        suspend operator fun invoke(): Flow<List<String>> = withContext(Dispatchers.IO){
            return@withContext repository.getQueries()
        }
    }
