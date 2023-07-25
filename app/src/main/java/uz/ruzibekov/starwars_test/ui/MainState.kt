package uz.ruzibekov.starwars_test.ui

import uz.ruzibekov.starwars_test.ui.screens.favorites.state.FavoritesState

data class MainState(
    val favoritesState: FavoritesState = FavoritesState()
)