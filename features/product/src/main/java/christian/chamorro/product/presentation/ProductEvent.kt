package christian.chamorro.product.presentation

import christian.chamorro.product.domain.models.Product

sealed class ProductEvent {
    object AddFavorite: ProductEvent()
    object RemoveFavorite: ProductEvent()
    data class GetProduct(val id: String): ProductEvent()
}