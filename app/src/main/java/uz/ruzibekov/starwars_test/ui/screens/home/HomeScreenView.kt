package uz.ruzibekov.starwars_test.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.MainLabel
import uz.ruzibekov.starwars_test.ui.components.MainListItem

object HomeScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(viewModel: MainViewModel) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = viewModel.search.value,
                onValueChange = { viewModel.search(it) }
            )

            LazyColumn {

                item {
                    MainLabel.Default(textRes = R.string.title_personages)
                }

                items(viewModel.personageList) { personage ->
                    MainListItem.Default(personage)
                }

                item {
                    MainLabel.Default(textRes = R.string.title_starships)
                }

                items(viewModel.starshipList) { starship ->
                    MainListItem.Default(
                        data = starship,
                        viewModel = viewModel
                    )
                }
            }
        }
    }

}