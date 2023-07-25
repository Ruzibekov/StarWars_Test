package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.domain.model.response.personage.Personage
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.theme.StarWarsIcons

object StarWarsListView {

    @Composable
    fun Default(viewModel: MainViewModel) {
        LazyColumn {

            item {
                Label(textRes = R.string.title_personages)
            }

            items(viewModel.personageList) { personage ->
                Item(personage)
            }

            item {
                Label(textRes = R.string.title_starships)
            }

            items(viewModel.starshipList) { starship ->
                Item(
                    data = starship,
                    viewModel = viewModel
                )
            }
        }
    }

    @Composable
    private fun Label(textRes: Int) {
        Text(text = stringResource(id = textRes))
    }

    @Composable
    private fun Item(personage: Personage) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = personage.name)

            Image(
                painter = painterResource(
                    id = if (personage.isFavorite)
                        StarWarsIcons.Favorite
                    else StarWarsIcons.Unfavorite
                ),
                contentDescription = "favorite icon"
            )
        }
    }

    @Composable
    private fun Item(data: Starship, viewModel: MainViewModel) {

        var isFavorite by remember { mutableStateOf(viewModel.isStarshipFavorite(data)) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = data.name)

            IconButton(
                onClick = {
                    if (isFavorite) {
                        viewModel.removeFavoriteStarship(data)
                    } else {
                        viewModel.addFavoriteStarship(data)
                    }
                    isFavorite = !isFavorite
                }
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isFavorite) StarWarsIcons.Favorite
                        else StarWarsIcons.Unfavorite
                    ),
                    contentDescription = "favorite icon",
                )
            }
        }
    }

}