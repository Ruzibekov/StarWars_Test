package uz.ruzibekov.starwars_test.ui.screens.home.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class HomeState(
    val search: MutableState<String> = mutableStateOf(""),
)