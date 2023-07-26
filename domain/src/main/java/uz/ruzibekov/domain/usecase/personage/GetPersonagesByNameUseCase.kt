package uz.ruzibekov.domain.usecase.personage

import kotlinx.coroutines.flow.Flow
import uz.ruzibekov.domain.model.response.personage.PersonagesBaseResponse

interface GetPersonagesByNameUseCase {

    suspend fun getPersonages(personageName: String): Flow<PersonagesBaseResponse>
}