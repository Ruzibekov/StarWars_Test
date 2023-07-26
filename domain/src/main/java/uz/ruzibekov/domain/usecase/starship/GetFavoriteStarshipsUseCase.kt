package uz.ruzibekov.domain.usecase.starship

import uz.ruzibekov.domain.model.entity.starship.StarshipEntity

interface GetFavoriteStarshipsUseCase {

    suspend fun getStarships(): List<StarshipEntity>
}