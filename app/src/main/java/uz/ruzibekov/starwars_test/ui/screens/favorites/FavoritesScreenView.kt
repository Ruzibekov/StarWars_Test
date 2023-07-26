package uz.ruzibekov.starwars_test.ui.screens.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.DataNotAvailableView
import uz.ruzibekov.starwars_test.ui.components.MainLabel
import uz.ruzibekov.starwars_test.ui.components.MainListItem
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors

object FavoritesScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(viewModel: MainViewModel) {

        Scaffold(
            topBar = {
                Text(
                    text = stringResource(id = R.string.favorites),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp),
                    color = StarWarsColors.White
                )
            },
            containerColor = StarWarsColors.Background
        ) { paddingValues ->

            Box(modifier = Modifier.padding(paddingValues)) {
                LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp)) {

                    if (viewModel.personageFavoriteList.isNotEmpty())
                        item {
                            MainLabel.Default(textRes = R.string.title_personages)
                        }

                    items(viewModel.personageFavoriteList) { personage ->
                        MainListItem.Default(personage, viewModel)
                    }

                    if (viewModel.starshipFavoriteList.isNotEmpty())
                        item {
                            MainLabel.Default(textRes = R.string.title_starships)
                        }

                    items(viewModel.starshipFavoriteList) { starship ->
                        MainListItem.Default(starship, viewModel)
                    }
                }
                if (viewModel.favoriteDataIsEmpty())
                    DataNotAvailableView.Default()
            }
        }
    }

}