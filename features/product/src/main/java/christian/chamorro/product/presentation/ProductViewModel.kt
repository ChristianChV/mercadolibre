package christian.chamorro.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.product.domain.usecases.AddFavoriteUseCase
import christian.chamorro.product.domain.usecases.GetProductByIdUseCase
import christian.chamorro.product.domain.usecases.ListenProductFavoriteUseCase
import christian.chamorro.product.domain.usecases.RemoveFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val listenProductFavoriteUseCase: ListenProductFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> = _state

    fun onEvent(event: ProductEvent) {
        when (event) {
            is ProductEvent.RemoveFavorite -> removeFavorite()
            is ProductEvent.AddFavorite -> addFavorite()
            is ProductEvent.GetProduct -> getProduct(event.id)
        }
    }

    private fun getProduct(id: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }

        val result = getProductByIdUseCase(id)

        when (result) {
            is AsyncResult.Failure -> {
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = result.error,
                        content = null
                    )
                }
            }

            is AsyncResult.Success -> {
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = null,
                        content = result.value
                    )
                }
                listenProductFavoriteUseCase(result.value.id).collect{ isFavorite ->
                    _state.update {
                        it.copy(isFavorite = isFavorite)
                    }
                }
            }
        }
    }

    private fun addFavorite() = viewModelScope.launch{
        val product = _state.value.content
        product?.let {
            addFavoriteUseCase(it)
        }
    }

    private fun removeFavorite() = viewModelScope.launch{
        val product = _state.value.content
        product?.let {
            removeFavoriteUseCase(it)
        }
    }
}