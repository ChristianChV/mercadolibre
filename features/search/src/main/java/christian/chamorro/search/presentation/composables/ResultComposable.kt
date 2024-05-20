package christian.chamorro.search.presentation.composables

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.network.presentation.networkErrorsAdapter.getDescription
import christian.chamorro.search.R
import christian.chamorro.search.domain.models.SearchResult
import christian.chamorro.search.presentation.SearchPageEvent
import christian.chamorro.search.presentation.SearchPageState
import christian.chamorro.uicomponents.error.ErrorScreen
import christian.chamorro.uicomponents.loading.LoadingScreen

@Composable
fun ResultComposable(
    state: SearchPageState,
    onEvent: (SearchPageEvent) -> Unit,
    query: String,
    goToProductDetail: (String) -> Unit
) {
    val context = LocalContext.current

    when {
        state.isSearchLoading -> LoadingScreen()
        state.isSearchError != null -> SetError(
            error = state.isSearchError,
            context = context,
            reload = { onEvent(SearchPageEvent.GetProductsByQuery(query)) }
        )

        state.searchContent != null -> SetContent(state.searchContent, goToProductDetail)
    }
}

@Composable
fun SetContent(
    result: SearchResult,
    goToProductDetail: (String) -> Unit
) {

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
            items(result.results) { searchProduct ->

                SearchResultItem(
                    searchProduct = searchProduct,
                    goToProductDetail = goToProductDetail
                )
            }
        }
    }

}

@Composable
private fun SetError(
    error: NetworkErrors,
    context: Context,
    reload: () -> Unit,
) {

    val titles = error.getDescription(context)

    ErrorScreen(
        title = titles.first,
        subtitle = titles.second,
        reload = { reload() }
    )
}