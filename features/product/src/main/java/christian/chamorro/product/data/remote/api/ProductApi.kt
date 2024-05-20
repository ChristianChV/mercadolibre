package christian.chamorro.product.data.remote.api

import christian.chamorro.product.data.remote.dtos.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Api to manage product resource.
 */
interface ProductApi {
    @GET("items/{id}")
    suspend fun getProductById(@Path("id") id: String): ProductDto
}