package christian.chamorro.search.routes

sealed class SearchRoutes(val route: String) {
    object Root: SearchRoutes("search")
    object Home: SearchRoutes("search/home")
}