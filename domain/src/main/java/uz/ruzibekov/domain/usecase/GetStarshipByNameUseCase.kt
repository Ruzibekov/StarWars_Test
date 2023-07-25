package uz.ruzibekov.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.ruzibekov.domain.model.starship.StarshipBaseResponse

interface GetStarshipByNameUseCase {

    suspend fun getStarships(name: String): Flow<StarshipBaseResponse>
}