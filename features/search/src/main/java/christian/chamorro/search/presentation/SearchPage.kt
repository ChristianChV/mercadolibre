package christian.chamorro.search.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.search.R
import christian.chamorro.search.presentation.composables.QueriesComposable
import christian.chamorro.search.presentation.composables.ResultComposable
import christian.chamorro.search.presentation.models.SearchActivePage.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage(
    navigationButton: @Composable () -> Unit,
    goToProductDetail: (String) -> Unit,
    searchState: SearchPageState,
    queryState: SearchQueryState,
    onEvent: (SearchPageEvent) -> Unit
) {

    BackHandler(searchState.activePage == Result) {
        onEvent(SearchPageEvent.SetActivePage(Queries))
    }

    LaunchedEffect(true) {
        onEvent(SearchPageEvent.GetQueries)
    }

    val query = remember {
        mutableStateOf("")
    }

    val interactionSourceQuery = remember {
        MutableInteractionSource()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.search_title)) },
                navigationIcon = navigationButton
            )
        },
        content = { contentPadding ->
            Column(
                Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = query.value,
                    onValueChange = { query.value = it },
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable {
                                onEvent(SearchPageEvent.GetProductsByQuery(query.value))
                                onEvent(SearchPageEvent.SetActivePage(Result))
                            },
                            painter = painterResource(
                                id = christian.chamorro.uicomponents.R.drawable.search_icon
                            ),
                            contentDescription = stringResource(id = R.string.search)
                        )
                    },
                    interactionSource = interactionSourceQuery.also { interactionSource ->
                        LaunchedEffect(interactionSource) {
                            interactionSource.interactions.collect {
                                if (it is PressInteraction.Release) {
                                    onEvent(SearchPageEvent.SetActivePage(Queries))
                                }
                            }
                        }
                    },
                    maxLines = 1
                )

                when (searchState.activePage) {
                    Queries -> QueriesComposable(
                        state = queryState,
                        onEvent = onEvent,
                        setQuery = { query.value = it }
                    )
                    Result -> ResultComposable(
                        state = searchState,
                        onEvent = onEvent,
                        query = query.value,
                        goToProductDetail = { goToProductDetail(it) }
                    )
                }


            }
        }
    )
}