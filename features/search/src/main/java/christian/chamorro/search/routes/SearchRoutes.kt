package christian.chamorro.search.routes

/**
 * Specify possible routes of screens in Search module, each one with string route property.
 */
sealed class SearchRoutes(val route: String) {
    object Root : SearchRoutes("search")

    object Home : SearchRoutes("search/home")
}
