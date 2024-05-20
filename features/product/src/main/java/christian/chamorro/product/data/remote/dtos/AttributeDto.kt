package christian.chamorro.product.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**
 * Attribute data access object.
 */
data class AttributeDto(
    val name: String,
    @SerializedName("value_name")
    val valueName: String?,
)