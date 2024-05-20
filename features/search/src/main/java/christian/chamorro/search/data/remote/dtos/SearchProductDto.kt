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
    val price: Double,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
)
