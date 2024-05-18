package christian.chamorro.product.data.local.adapters

import christian.chamorro.core.adapters.FromModelAdapter
import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.domain.models.Attribute

class AttributeAdapter :
    ToModelAdapter<Attribute, AttributeEntity>,
    FromModelAdapter<Attribute, AttributeEntity> {
    override fun fromModel(model: Attribute): AttributeEntity  = AttributeEntity(
        id = "",
        productId = model.productId,
        name = model.name,
        valueName = model.valueName
    )

    override fun toModel(data: AttributeEntity): Attribute = Attribute(
        productId = data.productId,
        name = data.name,
        valueName = data.valueName
    )
}