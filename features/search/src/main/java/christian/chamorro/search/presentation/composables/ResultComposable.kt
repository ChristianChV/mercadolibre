package christian.chamorro.search.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.R
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.presentation.SearchPageEvent
import christian.chamorro.search.presentation.SearchPageState
import christian.chamorro.uicomponents.error.ErrorScreen
import christian.chamorro.uicomponents.adapters.toCurrency
import christian.chamorro.uicomponents.loading.LoadingScreen
import coil.compose.AsyncImage

@Composable
fun ResultComposable(
    state: SearchPageState,
    onEvent: (SearchPageEvent)->Unit,
    query: String,
    goToProductDetail: (String)-> Unit
){

    when{
        state.isSearchLoading -> LoadingScreen()
        state.isSearchError != null -> SetError(state, onEvent, query)
        state.searchContent != null -> SetContent(state.searchContent, goToProductDetail)
    }
}

@Composable
fun SetContent(
    result: SearchResult,
    goToProductDetail: (String)-> Unit
) {
    val typo = MaterialTheme.typography

    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(4.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.total_found) + "${result.totalResults}")
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalItemSpacing = 20.dp
            ) {
            items(result.results){ searchProduct->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { goToProductDetail(searchProduct.id) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(Modifier.fillMaxSize()) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            model = searchProduct.thumbnail,
                            contentDescription = stringResource(id = R.string.product_image),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = searchProduct.title, textAlign = TextAlign.Center, style = typo.labelMedium)
                            Spacer(modifier = Modifier.height(12.dp) )
                            Text(text = searchProduct.originalPrice.toCurrency(), textAlign = TextAlign.Center, style = typo.bodyMedium)
                            Spacer(modifier = Modifier.height(12.dp) )
                            Text(text = stringResource(
                                id = R.string.available_ammount) + "${searchProduct.availableQuantity}",
                                textAlign = TextAlign.Center,
                                style = typo.labelSmall)
                        }
                    }
                }
            }
        }
    }

}

@Composable
private fun SetError(
    state: SearchPageState,
    onEvent: (SearchPageEvent)->Unit,
    query: String
){

    val (title, subtitle) = when(state.isSearchError){
        is NetworkErrors.ApiException -> stringResource(id = R.string.api_error) to "${stringResource(id = R.string.error)} ${state.isSearchError.code}"
        NetworkErrors.NoInternetException -> stringResource(id = R.string.network_error) to stringResource(id = R.string.verify_network_connection)
        NetworkErrors.UnknownException -> stringResource(id = R.string.unknown_error) to stringResource(id = R.string.try_again)
        null -> "" to ""
    }
    ErrorScreen(
        title = title,
        subtitle = subtitle,
        reload = { onEvent(SearchPageEvent.GetProductsByQuery(query)) }
    )
}