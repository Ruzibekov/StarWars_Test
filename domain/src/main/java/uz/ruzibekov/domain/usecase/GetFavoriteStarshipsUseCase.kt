package uz.ruzibekov.domain.usecase

import uz.ruzibekov.domain.model.entity.StarshipEntity

interface GetFavoriteStarshipsUseCase {

    suspend fun getStarships(): List<StarshipEntity>
}