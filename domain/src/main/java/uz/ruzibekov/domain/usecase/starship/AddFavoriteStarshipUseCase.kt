package uz.ruzibekov.domain.usecase.starship

import uz.ruzibekov.domain.model.entity.starship.StarshipEntity

interface AddFavoriteStarshipUseCase {

    suspend fun addStarship(starship: StarshipEntity)
}