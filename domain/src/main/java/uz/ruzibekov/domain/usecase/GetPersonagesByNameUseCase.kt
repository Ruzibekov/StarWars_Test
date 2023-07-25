package uz.ruzibekov.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.ruzibekov.domain.model.personage.PersonagesBaseResponse

interface GetPersonagesByNameUseCase {

    suspend fun getPersonages(personageName: String): Flow<PersonagesBaseResponse>
}