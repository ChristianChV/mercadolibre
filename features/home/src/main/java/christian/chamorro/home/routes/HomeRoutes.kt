package christian.chamorro.home.routes

sealed class HomeRoutes(val route: String) {
    object Root: HomeRoutes("home")
    object Home: HomeRoutes("home/homePage")
}