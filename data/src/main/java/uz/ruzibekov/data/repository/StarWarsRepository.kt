package uz.ruzibekov.data.repository

import kotlinx.coroutines.flow.flow
import uz.ruzibekov.data.remote.StarWarsService
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase
import javax.inject.Inject


class StarWarsRepository @Inject constructor(
    private val service: StarWarsService
) : GetPersonagesByNameUseCase, GetStarshipByNameUseCase {

    override suspend fun getPersonages(personageName: String) = flow {
        val result = service.getPersonagesByName(personageName)

        if (result.isSuccessful && result.body() != null)
            emit(result.body()!!)
    }

    override suspend fun getStarships(name: String) = flow {
        val result = service.getStarshipsByName(name)

        if (result.isSuccessful && result.body() != null)
            emit(result.body()!!)
    }

}