package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.domain.model.personage.Personage
import uz.ruzibekov.domain.model.starship.Starship
import uz.ruzibekov.starwars_test.R

object StarWarsListView {

    @Composable
    fun Default(
        personageList: List<Personage>,
        starshipList: List<Starship>
    ) {
        LazyColumn {

            item {
                Label(textRes = R.string.title_personages)
            }

            items(personageList) { personage ->
                Item(personage)
            }

            item {
                Label(textRes = R.string.title_starships)
            }

            items(starshipList) {starship ->
                Item(starship)
            }
        }
    }

    @Composable
    private fun Label(textRes: Int) {
        Text(text = stringResource(id = textRes))

    }

    @Composable
    private fun Item(personage: Personage) {
        Text(text = personage.name)
    }

    @Composable
    private fun Item(starship: Starship) {
        Text(text = starship.name)
    }
}