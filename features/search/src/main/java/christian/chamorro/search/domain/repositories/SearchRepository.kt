package christian.chamorro.search.domain.repositories

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors>

    suspend fun deleteQuery(query: String)

    suspend fun getQueries(): Flow<List<String>>
}
