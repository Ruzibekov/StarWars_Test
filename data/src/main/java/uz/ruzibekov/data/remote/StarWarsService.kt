package uz.ruzibekov.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.ruzibekov.domain.model.personage.PersonagesBaseResponse

interface StarWarsService {

    @GET("people?ordering=name")
    suspend fun getPersonagesByName(@Query("search") name: String): Response<PersonagesBaseResponse>

//    @GET("planets")
//    fun getPlanetsByName(): Response<>
}