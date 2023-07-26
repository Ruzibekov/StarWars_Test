package uz.ruzibekov.starwars_test.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import uz.ruzibekov.starwars_test.ui.components.MainLabel
import uz.ruzibekov.starwars_test.ui.components.MainListItem
import uz.ruzibekov.starwars_test.ui.components.SearchTextField
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors

object HomeScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(viewModel: MainViewModel) {

        Scaffold(
            topBar = {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {

                    Text(
                        text = stringResource(id = R.string.home),
                        style = MaterialTheme.typography.bodyLarge,
                        color = StarWarsColors.White
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    SearchTextField.Default(viewModel = viewModel)
                }
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(all = 16.dp),
            ) {

                LazyColumn {

                    item {
                        MainLabel.Default(textRes = R.string.title_personages)
                    }

                    items(viewModel.personageList) { personage ->
                        MainListItem.Default(personage, viewModel)
                    }

                    item {
                        MainLabel.Default(textRes = R.string.title_starships)
                    }

                    items(viewModel.starshipList) { starship ->
                        MainListItem.Default(starship, viewModel)
                    }
                }
            }
        }
    }

}