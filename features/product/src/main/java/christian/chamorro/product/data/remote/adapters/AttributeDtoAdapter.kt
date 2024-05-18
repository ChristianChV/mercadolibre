package christian.chamorro.product.data.remote.adapters

import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.product.data.remote.dtos.AttributeDto
import christian.chamorro.product.domain.models.Attribute

class AttributeDtoAdapter :ToModelAdapter<Attribute, AttributeDto> {
    override fun toModel(data: AttributeDto): Attribute = Attribute(
        productId = "",
        name = data.name,
        valueName = data.valueName
    )
}