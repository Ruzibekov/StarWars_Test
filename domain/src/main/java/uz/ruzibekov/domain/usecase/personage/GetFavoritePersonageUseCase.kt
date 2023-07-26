package uz.ruzibekov.domain.usecase.personage

import uz.ruzibekov.domain.model.entity.personage.PersonageEntity

interface GetFavoritePersonageUseCase {

    suspend fun getPersonages(): List<PersonageEntity>
}