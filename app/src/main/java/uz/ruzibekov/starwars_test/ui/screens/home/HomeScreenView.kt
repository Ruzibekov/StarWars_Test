package uz.ruzibekov.starwars_test.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.components.StarWarsListView

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

            StarWarsListView.Default(
                personageList = viewModel.personageList,
                starshipList = viewModel.starshipList
            )
        }
    }

}