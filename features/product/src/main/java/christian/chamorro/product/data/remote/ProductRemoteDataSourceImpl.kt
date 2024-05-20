package christian.chamorro.product.data.remote

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.data.datasources.ProductRemoteDataSource
import christian.chamorro.product.data.remote.adapters.ProductDtoAdapter
import christian.chamorro.product.data.remote.api.ProductApi
import christian.chamorro.product.domain.models.Product
import javax.inject.Inject

class ProductRemoteDataSourceImpl
    @Inject
    constructor(
        private val productAdapter: ProductDtoAdapter,
        private val api: ProductApi,
    ) : ProductRemoteDataSource {
        override suspend fun getProductById(id: String): AsyncResult<Product, NetworkErrors> {
            return try {
                val resultEntity = api.getProductById(id)
                val result = productAdapter.toModel(resultEntity)
                AsyncResult.Success(result)
            } catch (e: Exception) {
                println(e.stackTrace)
                AsyncResult.Failure(NetworkErrors.fromException(e))
            }
        }
    }
