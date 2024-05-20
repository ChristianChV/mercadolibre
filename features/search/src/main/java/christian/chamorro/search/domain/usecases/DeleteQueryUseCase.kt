package christian.chamorro.search.domain.usecases

import christian.chamorro.search.domain.repositories.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Delete query
 */
class DeleteQueryUseCase
    @Inject
    constructor(
        private val repository: SearchRepository,
    ) {
        suspend operator fun invoke(query: String) =
            withContext(Dispatchers.IO) {
                repository.deleteQuery(query)
            }
    }
