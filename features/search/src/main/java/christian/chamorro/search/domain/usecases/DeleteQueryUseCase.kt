package christian.chamorro.search.domain.usecases

import christian.chamorro.search.domain.repositories.SearchRepository
import javax.inject.Inject

class DeleteQueryUseCase
    @Inject
    constructor(
        private val repository: SearchRepository,
    ) {
        suspend operator fun invoke(query: String) {
            repository.deleteQuery(query)
        }
    }
