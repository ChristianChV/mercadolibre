package christian.chamorro.product.data.local.adapters

import christian.chamorro.core.adapters.FromModelAdapter
import christian.chamorro.core.adapters.ToModelAdapter
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.domain.models.Attribute
import javax.inject.Inject

class AttributeAdapter @Inject constructor() :
    ToModelAdapter<Attribute, AttributeEntity>,
    FromModelAdapter<Attribute, AttributeEntity> {
    override fun fromModel(model: Attribute): AttributeEntity  = AttributeEntity(
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