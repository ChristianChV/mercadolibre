package christian.chamorro.search.data.datasources

import kotlinx.coroutines.flow.Flow

/**
 * Local data source for queries management.
 */
interface SearchLocalDataSource {
    /**
     * Get all queries in storage.
     */
    suspend fun getQueries(): Flow<List<String>>

    /**
     * Save query in storage.
     */
    suspend fun saveQuery(query: String)

    /**
     * Delete query in storage.
     */
    suspend fun deleteQuery(query: String)
}
