package christian.chamorro.product.data.local

import christian.chamorro.product.data.datasources.ProductLocalDataSource
import christian.chamorro.product.data.local.adapters.CommonEntityToProductAdapter
import christian.chamorro.product.data.local.adapters.ProductToEntitiesAdapter
import christian.chamorro.product.data.local.daos.ProductDao
import christian.chamorro.product.domain.models.Product
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(
    private val dao: ProductDao,
    private val commonAdapter: CommonEntityToProductAdapter,
    private val toEntitiesAdapter: ProductToEntitiesAdapter
) : ProductLocalDataSource {
    override suspend fun addToFavorites(product: Product) {
        val (productEntity, attributeEntities) = toEntitiesAdapter.fromModel(product)
        dao.insertProductAndAttributes(productEntity, attributeEntities)
    }

    override suspend fun removeFromFavorites(product: Product) {
        val productEntity = toEntitiesAdapter.fromModel(product).first
        dao.removeFromFavorites(productEntity)
    }

    override suspend fun getFavorites(): List<Product> {
        val common = dao.getFavorites()
        return commonAdapter.toModelList(common)
    }
}