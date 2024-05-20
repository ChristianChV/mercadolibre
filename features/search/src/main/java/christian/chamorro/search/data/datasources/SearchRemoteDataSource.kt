package christian.chamorro.search.data.datasources

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.domain.models.SearchResult

/**
 * Remote data source to manage product.
 */
interface SearchRemoteDataSource {

    /**
     * Function get a product by id from remote source.
     * @param id: product identifier
     * @return AsyncResult to handle success and failure result
     */
    suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors>
}
