package christian.chamorro.home.routes

/**
 * Specify possible routes of screens in Search module, each one with string route property.
 */
sealed class HomeRoutes(val route: String) {
    object Root: HomeRoutes("home")
    object Home: HomeRoutes("home/homePage")
}