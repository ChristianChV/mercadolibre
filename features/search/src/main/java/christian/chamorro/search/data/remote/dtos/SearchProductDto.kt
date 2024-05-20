package christian.chamorro.search.data.remote.dtos

import com.google.gson.annotations.SerializedName

/**
 * SearchProduct data access object.
 */
data class SearchProductDto(
    val id: String,
    val title: String,
    val permalink: String,
    val thumbnail: String,
    @SerializedName("original_price")
    val originalPrice: Double,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
)
