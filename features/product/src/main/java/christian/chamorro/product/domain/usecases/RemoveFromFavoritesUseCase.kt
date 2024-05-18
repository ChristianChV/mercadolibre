package christian.chamorro.product.domain.usecases

import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.domain.repositories.ProductRepository
import javax.inject.Inject

class RemoveFromFavoritesUseCase @Inject constructor(
    private val repository: ProductRepository
){

    suspend operator fun invoke(product: Product){
        repository.removeFromFavorites(product)
    }
}