package christian.chamorro.search.domain.repositories

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult
import kotlinx.coroutines.flow.Flow


/**
 * Repository to manage search resources.
 */
interface SearchRepository {

    /**
     * Get products by query from remote resource.
     */
    suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors>

    /**
     * Delete query
     */
    suspend fun deleteQuery(query: String)

    /**
     * Get all queries in storage
     */
    suspend fun getQueries(): Flow<List<String>>
}
