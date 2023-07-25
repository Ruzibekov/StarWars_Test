package uz.ruzibekov.starwars_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.navigation.MainNavHost
import uz.ruzibekov.starwars_test.ui.theme.StarWars_TestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            StarWars_TestTheme {
                MainNavHost.Default(
                    navController = navController,
                    state = viewModel.state,
                    viewModel = viewModel
                )
            }
        }

        viewModel.fetchFavoritesList()
    }

}