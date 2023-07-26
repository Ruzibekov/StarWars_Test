package uz.ruzibekov.domain.usecase.personage

import uz.ruzibekov.domain.model.entity.personage.PersonageEntity

interface AddFavoritePersonageUseCase {

    suspend fun addPersonage(data: PersonageEntity)
}