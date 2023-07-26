package uz.ruzibekov.starwars_test.ui.navigation

sealed class ScreensRoute(val route: String) {
    object HomeScreen : ScreensRoute("home-screen-route")
    object FavoritesScreen : ScreensRoute("favorites-screen-route")
}
