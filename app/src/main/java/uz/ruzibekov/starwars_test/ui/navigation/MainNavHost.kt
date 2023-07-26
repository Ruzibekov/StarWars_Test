package uz.ruzibekov.starwars_test.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ruzibekov.starwars_test.ui.MainState
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.MainBottomNavView
import uz.ruzibekov.starwars_test.ui.screens.favorites.FavoritesScreenView
import uz.ruzibekov.starwars_test.ui.screens.home.HomeScreenView

object MainNavHost {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        navController: NavHostController,
        state: MainState,
        viewModel: MainViewModel
    ) {
        Scaffold(
            bottomBar = { MainBottomNavView.Default(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = ScreensRoute.HomeScreen.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(ScreensRoute.HomeScreen.route) {
                    HomeScreenView.Default(viewModel)
                }
                composable(ScreensRoute.FavoritesScreen.route) {
                    FavoritesScreenView.Default(state.favoritesState)
                }
            }
        }
    }
}