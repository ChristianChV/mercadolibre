package christian.chamorro.search.data

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.data.datasources.SearchLocalDataSource
import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.domain.repositories.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl
    @Inject
    constructor(
        private val local: SearchLocalDataSource,
        private val remote: SearchRemoteDataSource,
    ) : SearchRepository {
        override suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors> {
            local.saveQuery(query)
            return remote.getProductsByQuery(query)
        }

        override suspend fun deleteQuery(query: String) {
            local.deleteQuery(query)
        }

        override suspend fun getQueries(): Flow<List<String>> {
            return local.getQueries()
        }
    }
