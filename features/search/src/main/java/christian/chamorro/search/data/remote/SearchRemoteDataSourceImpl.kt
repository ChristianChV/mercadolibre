package christian.chamorro.search.data.remote

import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.data.remote.api.SearchApi
import christian.chamorro.search.domain.models.SearchProduct
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val api: SearchApi
): SearchRemoteDataSource {
    override suspend fun getProductsByQuery(query: String): List<SearchProduct> {
        TODO("Not yet implemented")
    }
}