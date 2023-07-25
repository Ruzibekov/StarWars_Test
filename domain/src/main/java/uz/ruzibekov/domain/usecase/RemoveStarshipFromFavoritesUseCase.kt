package uz.ruzibekov.domain.usecase

import uz.ruzibekov.domain.model.response.starship.Starship


interface RemoveStarshipFromFavoritesUseCase {

    suspend fun removeStarship(starship: Starship)
}