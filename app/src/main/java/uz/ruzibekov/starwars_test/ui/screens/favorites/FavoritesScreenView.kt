package uz.ruzibekov.starwars_test.ui.screens.favorites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.MainLabel
import uz.ruzibekov.starwars_test.ui.components.MainListItem

object FavoritesScreenView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        LazyColumn(contentPadding = PaddingValues(all = 16.dp)) {

            item {
                MainLabel.Default(textRes = R.string.title_personages)
            }

            items(viewModel.personageFavoriteList) { personage ->
                MainListItem.Default(personage, viewModel)
            }

            item {
                MainLabel.Default(textRes = R.string.title_starships)
            }

            items(viewModel.starshipFavoriteList) { starship ->
                MainListItem.Default(starship, viewModel)
            }
        }
    }

}