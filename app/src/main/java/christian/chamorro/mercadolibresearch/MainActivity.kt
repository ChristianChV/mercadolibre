package christian.chamorro.mercadolibresearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import christian.chamorro.home.homeGraph
import christian.chamorro.home.routes.HomeRoutes
import christian.chamorro.mercadolibresearch.ui.theme.MercadoLibreSearchTheme

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
                        navController = navController,
                        onGoToSearch = {}
                    )
                }
            }
        }
    }
}