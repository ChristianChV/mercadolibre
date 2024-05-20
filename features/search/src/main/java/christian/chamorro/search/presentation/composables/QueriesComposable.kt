package christian.chamorro.search.presentation.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.SwipeToDismissBoxValue.*
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.search.R
import christian.chamorro.search.presentation.SearchPageEvent
import christian.chamorro.search.presentation.SearchPageState
import christian.chamorro.search.presentation.SearchQueryState
import christian.chamorro.uicomponents.colors.AppColors
import christian.chamorro.uicomponents.loading.LoadingScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun QueriesComposable(
    state: SearchQueryState,
    onEvent: (SearchPageEvent) -> Unit,
    setQuery: (String) -> Unit
) {

    when {
        state.isQueriesLoading -> LoadingScreen()
        state.queriesContent != null && state.queriesContent.isEmpty() -> SetEmpty()
        !state.queriesContent.isNullOrEmpty() -> SetQueries(
            state.queriesContent,
            onEvent,
            setQuery
        )
    }
}

@Composable
private fun SetEmpty() {

    val typo = MaterialTheme.typography

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(
                id = R.string.empty_queries
            ),
            style = typo.titleSmall,
            color = AppColors.Primary()
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SetQueries(
    queries: List<String>,
    onEvent: (SearchPageEvent) -> Unit,
    setQuery: (String) -> Unit,
) {

    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {

            items(queries) { query ->

                Spacer(modifier = Modifier.height(6.dp))

                QueryItem(
                    query = query,
                    setQuery = setQuery,
                    getProductsByQuery = { onEvent(SearchPageEvent.GetProductsByQuery(it)) },
                    deleteQuery = { onEvent(SearchPageEvent.DeleteQuery(it)) }
                )
            }
        }
    }
}
