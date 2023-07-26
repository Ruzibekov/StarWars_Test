package uz.ruzibekov.starwars_test.ui.screens.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.MainLabel
import uz.ruzibekov.starwars_test.ui.components.MainListItem

object FavoritesScreenView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        LazyColumn {

            item {
                MainLabel.Default(textRes = R.string.title_personages)
            }

            items(viewModel.personageFavoriteList) { personage ->
                MainListItem.Default(personage)
            }

            item {
                MainLabel.Default(textRes = R.string.title_starships)
            }

            items(viewModel.starshipFavoriteList) { starship ->
                MainListItem.Default(
                    data = starship,
                    viewModel = viewModel
                )
            }
        }
    }

}