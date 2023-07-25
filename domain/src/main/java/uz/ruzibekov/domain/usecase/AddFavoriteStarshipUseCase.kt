package uz.ruzibekov.domain.usecase

import uz.ruzibekov.domain.model.entity.StarshipEntity

interface AddFavoriteStarshipUseCase {

    suspend fun addStarship(starship: StarshipEntity)
}