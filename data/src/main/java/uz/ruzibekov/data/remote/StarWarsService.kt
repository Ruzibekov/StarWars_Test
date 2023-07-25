package uz.ruzibekov.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.ruzibekov.domain.model.response.personage.PersonagesBaseResponse
import uz.ruzibekov.domain.model.response.starship.StarshipBaseResponse

interface StarWarsService {

    @GET("people?ordering=name")
    suspend fun getPersonagesByName(@Query("search") name: String): Response<PersonagesBaseResponse>

    @GET("starships?ordering=name")
    suspend fun getStarshipsByName(@Query("search") name: String): Response<StarshipBaseResponse>

//    @GET("planets")
//    fun getPlanetsByName(): Response<>
}