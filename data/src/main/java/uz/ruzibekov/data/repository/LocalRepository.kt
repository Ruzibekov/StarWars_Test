package uz.ruzibekov.data.repository

import uz.ruzibekov.data.local.FavoritesDao
import uz.ruzibekov.domain.model.entity.StarshipEntity
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.domain.model.response.starship.toStarship
import uz.ruzibekov.domain.usecase.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.RemoveStarshipFromFavoritesUseCase
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val dao: FavoritesDao
) : AddFavoriteStarshipUseCase, GetFavoriteStarshipsUseCase, RemoveStarshipFromFavoritesUseCase {

    override suspend fun addStarship(starship: StarshipEntity) {
        dao.insertStarship(starship)
    }

    override suspend fun getStarships(): List<StarshipEntity> {
        return dao.getStarshipList()
    }

    override suspend fun removeStarship(starship: Starship) {
        dao.getStarshipList().forEach { // todo write this code to usecase
            if (it.toStarship() == starship)
                dao.deleteById(it.id)
        }
    }

}