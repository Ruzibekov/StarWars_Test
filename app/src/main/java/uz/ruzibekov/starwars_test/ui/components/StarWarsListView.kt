package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.domain.model.personage.Personage
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel

object StarWarsListView {

    @Composable
    fun Default(viewModel: MainViewModel) {
        LazyColumn {

            item {
                Label(textRes = R.string.title_personages)
            }

            items(viewModel.personageList){personage ->
                ItemPersonage(personage)
            }

            item {
                Label(textRes = R.string.title_starships)
            }

//            items(viewModel.)
        }
    }

    @Composable
    private fun Label(textRes: Int) {
        Text(text = stringResource(id = textRes))

    }

    @Composable
    private fun ItemPersonage(personage: Personage) {
        Text(text = personage.name)
    }

    @Composable
    private fun ItemStarship() {

    }
}