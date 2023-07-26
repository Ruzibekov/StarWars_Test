package uz.ruzibekov.data.repository

import uz.ruzibekov.data.local.FavoritesDao
import uz.ruzibekov.domain.model.entity.personage.PersonageEntity
import uz.ruzibekov.domain.model.entity.starship.StarshipEntity
import uz.ruzibekov.domain.model.response.personage.Personage
import uz.ruzibekov.domain.model.response.personage.toPersonage
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.domain.model.response.starship.toStarship
import uz.ruzibekov.domain.usecase.personage.AddFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.GetFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.RemovePersonageFromFavoritesUseCase
import uz.ruzibekov.domain.usecase.starship.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.starship.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.starship.RemoveStarshipFromFavoritesUseCase
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val dao: FavoritesDao
) : AddFavoriteStarshipUseCase, GetFavoriteStarshipsUseCase, RemoveStarshipFromFavoritesUseCase,
    AddFavoritePersonageUseCase, GetFavoritePersonageUseCase, RemovePersonageFromFavoritesUseCase {

    override suspend fun addStarship(starship: StarshipEntity) {
        dao.insertStarship(starship)
    }

    override suspend fun getStarships(): List<StarshipEntity> {
        return dao.getStarshipList()
    }

    override suspend fun removeStarship(starship: Starship) {
        dao.getStarshipList().forEach { // todo write this code to usecase
            if (it.toStarship() == starship)
                dao.deleteStarshipById(it.id)
        }
    }

    override suspend fun addPersonage(data: PersonageEntity) {
        dao.insertPersonage(data)
    }

    override suspend fun getPersonages(): List<PersonageEntity> {
        return dao.getPersonageList()
    }

    override suspend fun removePersonage(data: Personage) {
        dao.getPersonageList().forEach {
            if (it.toPersonage() == data)
                dao.deletePersonageById(it.id)
        }
    }

}