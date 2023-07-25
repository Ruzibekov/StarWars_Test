package uz.ruzibekov.starwars_test.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.ruzibekov.starwars_test.ui.screens.home.state.HomeState
import uz.ruzibekov.starwars_test.ui.theme.StarWars_TestTheme

object HomeScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: HomeState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = state.search.value,
                onValueChange = { state.search.value = it }
            )

        }
    }
}

@Preview
@Composable
fun Preview() {
    StarWars_TestTheme() {
        val state = HomeState()
        HomeScreenView.Default(state)
    }
}