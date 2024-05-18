package christian.chamorro.search.data.remote.api

import christian.chamorro.search.data.remote.dtos.SearchResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/sites/MLA/search")
    suspend fun getProductsByQuery(@Query("q") query: String): SearchResultDto
}