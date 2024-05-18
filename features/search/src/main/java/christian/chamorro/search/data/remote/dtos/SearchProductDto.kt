package christian.chamorro.search.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class SearchProductDto(
    val id: String,
    val title: String,
    val permalink: String,
    val thumbnail: String,
    @SerializedName("original_price")
    val originalPrice: Long,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
)
