package christian.chamorro.search.data.datasources

import kotlinx.coroutines.flow.Flow

interface SearchLocalDataSource {

    suspend fun getQueries(): Flow<List<String>>

    suspend fun saveQuery(query: String)

    suspend fun deleteQuery(query: String)


}