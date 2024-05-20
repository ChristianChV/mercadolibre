package christian.chamorro.product

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import christian.chamorro.product.presentation.ProductPage
import christian.chamorro.product.presentation.ProductViewModel
import christian.chamorro.product.routes.ProductRoutes
import christian.chamorro.uicomponents.navigation.NavigationButton

fun NavGraphBuilder.productGraph(
    navController: NavController
){
    navigation(startDestination = ProductRoutes.Home.route, route = ProductRoutes.Root.route) {

        composable(ProductRoutes.Home.route){ entry ->
            val viewmodel = hiltViewModel<ProductViewModel>()
            val id = entry.arguments?.getString("id") ?: ""
            ProductPage(
                navigationButton = { NavigationButton(navController = navController) },
                state = viewmodel.state.collectAsState().value,
                onEvent = { viewmodel.onEvent(it) },
                id = id
            )
        }
    }
}