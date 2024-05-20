package christian.chamorro.product.presentation

import android.content.Context
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.network.presentation.networkErrorsAdapter.getDescription
import christian.chamorro.product.R
import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.presentation.composables.ProductAttributes
import christian.chamorro.product.presentation.composables.ProductHeader
import christian.chamorro.uicomponents.error.ErrorScreen
import christian.chamorro.uicomponents.loading.LoadingScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductPage(
    navigationButton: @Composable () -> Unit,
    state: ProductState,
    onEvent: (ProductEvent) -> Unit,
    id: String
) {

    val context = LocalContext.current


    LaunchedEffect(true) {
        onEvent(ProductEvent.GetProduct(id))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = { Text(stringResource(id = R.string.product_title)) },
                navigationIcon = navigationButton,
            )
        },
        content = { contentPadding ->
            Column(
                Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
                    .padding(12.dp),
            ) {

                when {
                    state.isLoading -> LoadingScreen()
                    state.isError != null -> SetError(
                        error = state.isError,
                        context = context,
                        reload = { onEvent(ProductEvent.GetProduct(id)) }
                    )

                    state.content != null -> SetContent(
                        product = state.content,
                        state = state,
                        onEvent = onEvent
                    )
                }

            }
        }
    )
}

@Composable
private fun SetContent(
    product: Product,
    state: ProductState,
    onEvent: (ProductEvent) -> Unit
) {
    val typo = MaterialTheme.typography
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(text = product.title, style = typo.labelLarge)
        Spacer(modifier = Modifier.height(24.dp))
        ProductHeader(
            product = product,
            isFavorite = state.isFavorite,
            onEvent = onEvent
        )
        Spacer(modifier = Modifier.height(12.dp))
        ProductAttributes(attributes = product.attributes)
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun SetError(
    error: NetworkErrors,
    reload: () -> Unit,
    context: Context
) {
    val titles = error.getDescription(context)
    ErrorScreen(
        modifier = Modifier.fillMaxSize(),
        title = titles.first,
        subtitle = titles.second,
        reload = { reload() }
    )
}