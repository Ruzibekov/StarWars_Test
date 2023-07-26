package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.navigation.ScreensRoute
import uz.ruzibekov.starwars_test.ui.theme.StarWarsIcons

object MainBottomNavView {

    @Composable
    fun Default(navController: NavHostController) {
        NavigationBar {

            Item(
                navController = navController,
                screenRoute = ScreensRoute.HomeScreen,
                icon = StarWarsIcons.Home,
                labelRes = R.string.home
            )

            Item(
                navController = navController,
                screenRoute = ScreensRoute.FavoritesScreen,
                icon = StarWarsIcons.Favorite,
                labelRes = R.string.favorites
            )
        }
    }

    @Composable
    fun RowScope.Item(
        navController: NavHostController,
        screenRoute: ScreensRoute,
        icon: Int,
        labelRes: Int
    ) {
        NavigationBarItem(
            selected = navController.currentDestination?.route == screenRoute.route,
            onClick = { navController.navigate(screenRoute.route) },
            icon = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "favorite icon"
                )
            },
            label = {
                Text(
                    text = stringResource(labelRes),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        )
    }
}