package christian.chamorro.product.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class AttributeDto(
    val name: String,
    @SerializedName("value_name")
    val valueName: String?,
)