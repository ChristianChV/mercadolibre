package christian.chamorro.search

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import christian.chamorro.search.presentation.SearchPage
import christian.chamorro.search.presentation.SearchPageViewModel
import christian.chamorro.search.routes.SearchRoutes
import christian.chamorro.uicomponents.navigation.NavigationButton

fun NavGraphBuilder.searchGraph(
    navController: NavController,
    goToProductDetail: (String)->Unit
){
    navigation(startDestination = SearchRoutes.Home.route, route = SearchRoutes.Root.route) {
        composable(SearchRoutes.Home.route){

            val viewmodel = hiltViewModel<SearchPageViewModel>()

            SearchPage(
                goToProductDetail = goToProductDetail,
                navigationButton = { NavigationButton(navController = navController) },
                searchState = viewmodel.searchState.collectAsState().value,
                queryState = viewmodel.queryState.collectAsState().value,
                onEvent = { viewmodel.onEvent(it) }
            )
        }
    }
}