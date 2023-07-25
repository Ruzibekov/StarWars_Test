package uz.ruzibekov.starwars_test.ui.navigation

sealed class NavScreens(val route: String) {
    object HomeScreen : NavScreens("home-screen-route")
    object FavoritesScreen : NavScreens("favorites-screen-route")
}
