package christian.chamorro.product.presentation.favoritebanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.domain.usecases.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesBannerViewModel
    @Inject
    constructor(
        private val getFavoritesUseCase: GetFavoritesUseCase,
    ) : ViewModel() {
        private val _state = MutableStateFlow(emptyList<Product>())
        val state: StateFlow<List<Product>> = _state

        fun getFavorites() =
            viewModelScope.launch {
                val result = getFavoritesUseCase()
                _state.update { result }
            }
    }
