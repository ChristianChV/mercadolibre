package christian.chamorro.search.data.datasources

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult

interface SearchRemoteDataSource {
    suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors>
}
