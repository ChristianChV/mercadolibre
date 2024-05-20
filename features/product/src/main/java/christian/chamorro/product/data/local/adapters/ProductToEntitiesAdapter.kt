package christian.chamorro.product.data.local.adapters

import christian.chamorro.core.adapters.FromModelAdapter
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.data.local.entities.ProductEntity
import christian.chamorro.product.domain.models.Product
import javax.inject.Inject
import javax.inject.Singleton


/**
 * This class adapt Product model to pair of ProductEntity and List of AttributeEntity.
 */
class ProductToEntitiesAdapter @Inject constructor(
    private val attributeAdapter: AttributeAdapter
) :
    FromModelAdapter<Product, Pair<ProductEntity, List<AttributeEntity>>> {
    override fun fromModel(model: Product): Pair<ProductEntity, List<AttributeEntity>> {
        val productEntity = ProductEntity(
            id = model.id,
            title = model.title,
            condition = model.condition,
            thumbnail = model.thumbnail,
            originalPrice = model.originalPrice,
            acceptsMercadopago = model.acceptsMercadopago,
            pictures = model.pictures,
            initialQuantity = model.initialQuantity,
            warranty = model.warranty
        )
        val attributeEntities = attributeAdapter.fromModeList(model.attributes)

        return productEntity to attributeEntities
    }
}