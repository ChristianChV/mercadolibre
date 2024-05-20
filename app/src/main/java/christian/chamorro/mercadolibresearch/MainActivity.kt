package christian.chamorro.mercadolibresearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import christian.chamorro.home.homeGraph
import christian.chamorro.home.routes.HomeRoutes
import christian.chamorro.mercadolibresearch.ui.theme.MercadoLibreSearchTheme
import christian.chamorro.product.productGraph
import christian.chamorro.product.routes.ProductRoutes
import christian.chamorro.search.routes.SearchRoutes
import christian.chamorro.search.searchGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadoLibreSearchTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = HomeRoutes.Root.route
                ) {
                    homeGraph(
                        goToSearch = { navController.navigate(SearchRoutes.Root.route) }
                    )
                    searchGraph(
                        navController = navController,
                        goToProductDetail = { navController.navigate(ProductRoutes.ToHome(it).route) }
                    )
                    productGraph(
                        navController = navController
                    )
                }
            }
        }
    }
}