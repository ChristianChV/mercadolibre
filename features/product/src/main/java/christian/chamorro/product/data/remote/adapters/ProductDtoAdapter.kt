package christian.chamorro.product.data.remote.adapters

import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.product.data.remote.dtos.ProductDto
import christian.chamorro.product.domain.models.Product
import javax.inject.Inject

class ProductDtoAdapter @Inject constructor(
    private val attributeAdapter: AttributeDtoAdapter
): ToModelAdapter<Product, ProductDto> {
    override fun toModel(data: ProductDto): Product = Product(
        id = data.id,
        title = data.title,
        condition = data.condition,
        thumbnail = data.thumbnail,
        originalPrice = data.originalPrice,
        initialQuantity = data.initialQuantity,
        acceptsMercadopago = data.acceptsMercadopago,
        warranty = data.warranty,
        attributes = attributeAdapter.toModelList(data.attributes).map { it.copy(productId = data.id) },
        pictures = data.pictures.map { it.url }
    )
}