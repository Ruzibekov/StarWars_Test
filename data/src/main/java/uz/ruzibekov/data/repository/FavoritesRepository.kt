package uz.ruzibekov.data.repository

import uz.ruzibekov.data.local.FavoritesDao
import uz.ruzibekov.domain.model.entity.StarshipEntity
import uz.ruzibekov.domain.usecase.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.GetFavoriteStarshipsUseCase
import javax.inject.Inject

class FavoritesRepository @Inject constructor(
    private val dao: FavoritesDao
): AddFavoriteStarshipUseCase, GetFavoriteStarshipsUseCase {

    override suspend fun addStarship(starship: StarshipEntity) {
        dao.insertStarship(starship)
    }

    override suspend fun getStarships(): List<StarshipEntity> {
        return dao.getStarshipList()
    }
}