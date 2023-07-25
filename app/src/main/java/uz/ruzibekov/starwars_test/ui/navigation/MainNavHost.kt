package uz.ruzibekov.starwars_test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ruzibekov.starwars_test.ui.MainState
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.screens.favorites.FavoritesScreenView
import uz.ruzibekov.starwars_test.ui.screens.home.HomeScreenView

object MainNavHost {

    @Composable
    fun Default(
        navController: NavHostController,
        state: MainState,
        viewModel: MainViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = NavScreens.HomeScreen.route
        ) {
            composable(NavScreens.HomeScreen.route) {
                HomeScreenView.Default(viewModel)
            }
            composable(NavScreens.FavoritesScreen.route) {
                FavoritesScreenView.Default(state.favoritesState)
            }
        }
    }
}