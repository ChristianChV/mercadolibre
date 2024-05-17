package christian.chamorro.search.data.datasources

import christian.chamorro.search.domain.models.SearchProduct
import retrofit2.http.GET

interface SearchRemoteDataSource {

    suspend fun getProductsByQuery(query: String): List<SearchProduct>
}