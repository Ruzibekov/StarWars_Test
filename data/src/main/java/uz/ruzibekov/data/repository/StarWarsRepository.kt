package uz.ruzibekov.data.repository

import kotlinx.coroutines.flow.flow
import uz.ruzibekov.data.remote.StarWarsService
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import javax.inject.Inject


class StarWarsRepository @Inject constructor(
    private val service: StarWarsService
) : GetPersonagesByNameUseCase {

    override suspend fun getPersonages(personageName: String) = flow {
        val result = service.getPersonagesByName(personageName)
        if (result.isSuccessful && result.body() != null)
            emit(result.body()!!)
    }

}