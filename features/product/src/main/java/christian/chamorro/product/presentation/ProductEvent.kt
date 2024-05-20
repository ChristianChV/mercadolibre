package christian.chamorro.product.presentation

sealed class ProductEvent {
    object AddFavorite : ProductEvent()

    object RemoveFavorite : ProductEvent()

    data class GetProduct(val id: String) : ProductEvent()
}
