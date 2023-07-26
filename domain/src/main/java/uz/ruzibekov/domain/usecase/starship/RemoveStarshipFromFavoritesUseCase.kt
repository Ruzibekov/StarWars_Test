package uz.ruzibekov.domain.usecase.starship

import uz.ruzibekov.domain.model.response.starship.Starship


interface RemoveStarshipFromFavoritesUseCase {

    suspend fun removeStarship(starship: Starship)
}