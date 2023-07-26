package uz.ruzibekov.domain.usecase.personage

import uz.ruzibekov.domain.model.response.personage.Personage


interface RemovePersonageFromFavoritesUseCase {

    suspend fun removePersonage(data: Personage)
}