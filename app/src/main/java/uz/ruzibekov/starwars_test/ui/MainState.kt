package uz.ruzibekov.starwars_test.ui

import uz.ruzibekov.starwars_test.ui.screens.favorites.state.FavoritesState
import uz.ruzibekov.starwars_test.ui.screens.home.state.HomeState

data class MainState(
    val homeState: HomeState = HomeState(),
    val favoritesState: FavoritesState = FavoritesState()
)