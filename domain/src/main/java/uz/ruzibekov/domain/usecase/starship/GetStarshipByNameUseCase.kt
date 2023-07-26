package uz.ruzibekov.domain.usecase.starship

import kotlinx.coroutines.flow.Flow
import uz.ruzibekov.domain.model.response.starship.StarshipBaseResponse

interface GetStarshipByNameUseCase {

    suspend fun getStarships(name: String): Flow<StarshipBaseResponse>
}