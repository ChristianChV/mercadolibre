package christian.chamorro.product.presentation

import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.product.domain.models.Product

data class ProductState(
    val isLoading: Boolean = false,
    val content: Product? = null,
    val isError: NetworkErrors? = null,
    val isFavorite: Boolean = false,
)
