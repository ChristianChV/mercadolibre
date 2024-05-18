package christian.chamorro.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import christian.chamorro.home.presentation.HomePage
import christian.chamorro.home.routes.HomeRoutes

fun NavGraphBuilder.homeGraph(
    navController: NavController,
    onGoToSearch: (String)->Unit
){
    navigation(startDestination = HomeRoutes.Home.route, route = HomeRoutes.Root.route) {

        composable(HomeRoutes.Home.route){
            HomePage()
        }
    }
}