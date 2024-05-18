package christian.chamorro.search.data.remote

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.data.remote.adapters.SearchDtoAdapter
import christian.chamorro.search.data.remote.api.SearchApi
import christian.chamorro.search.domain.models.SearchResult
import javax.inject.Inject

class SearchRemoteDataSourceImpl
    @Inject
    constructor(
        private val api: SearchApi,
        private val searchDtoAdapter: SearchDtoAdapter,
    ) : SearchRemoteDataSource {
        override suspend fun getProductsByQuery(query: String): AsyncResult<SearchResult, NetworkErrors> {
            return try {
                val result = api.getProductsByQuery(query)
                val searchResult = searchDtoAdapter.toModel(result)
                AsyncResult.Success(searchResult)
            } catch (e: Exception) {
                println(e.stackTrace)
                AsyncResult.Failure(NetworkErrors.fromException(e))
            }
        }
    }
