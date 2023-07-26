package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.ruzibekov.starwars_test.ui.navigation.ScreensRoute
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors
import uz.ruzibekov.starwars_test.ui.theme.StarWarsIcons

object MainBottomNavView {

    @Composable
    fun Default(navController: NavHostController) {
        NavigationBar(
            containerColor = StarWarsColors.Dark
        ) {

            Item(
                navController = navController,
                screenRoute = ScreensRoute.HomeScreen,
                icon = StarWarsIcons.Home,
            )

            Item(
                navController = navController,
                screenRoute = ScreensRoute.FavoritesScreen,
                icon = StarWarsIcons.Favorite,
            )
        }
    }

    @Composable
    fun RowScope.Item(
        navController: NavHostController,
        screenRoute: ScreensRoute,
        icon: Int,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        NavigationBarItem(
            selected = navBackStackEntry?.destination?.route == screenRoute.route,
            onClick = {
                navController.navigate(screenRoute.route) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "favorite icon"
                )
            },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = StarWarsColors.Dark,
                unselectedIconColor = StarWarsColors.Gray,
                indicatorColor = StarWarsColors.White
            )
        )
    }
}