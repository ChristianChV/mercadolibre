package christian.chamorro.product.data.local.adapters

import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.product.data.local.entities.ProductWithAttributes
import christian.chamorro.product.domain.models.Product
import javax.inject.Inject

/**
 * This class adapt Product model to ProductWithAttributes model.
 */
class CommonEntityToProductAdapter @Inject constructor(
    private val attributeAdapter: AttributeAdapter
) : ToModelAdapter<Product, ProductWithAttributes> {
    override fun toModel(data: ProductWithAttributes): Product = Product(
        id = data.product.id,
        title = data.product.title,
        condition = data.product.condition,
        thumbnail = data.product.thumbnail,
        initialQuantity = data.product.initialQuantity,
        price = data.product.originalPrice,
        acceptsMercadopago = data.product.acceptsMercadopago,
        pictures = data.product.pictures,
        warranty = data.product.warranty,
        attributes = attributeAdapter.toModelList(data.attributes)
    )
}