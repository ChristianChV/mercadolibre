package christian.chamorro.product.routes

/**
 * Specify possible routes of screens in Product module, each one with string route property.
 */
sealed class ProductRoutes(val route: String) {
    object Root : ProductRoutes("product")

    object Home : ProductRoutes("product/home?id={id}")

    data class ToHome(val id: String) : ProductRoutes("product/home?id=$id")
}
