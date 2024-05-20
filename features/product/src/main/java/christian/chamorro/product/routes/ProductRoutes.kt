package christian.chamorro.product.routes

sealed class ProductRoutes(val route: String) {

    object Root: ProductRoutes("product")
    object Home: ProductRoutes("product/home?id={id}")
    data class ToHome(val id: String): ProductRoutes("product/home?id=${id}")
}