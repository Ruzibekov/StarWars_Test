package uz.ruzibekov.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.domain.model.entity.personage.PersonageEntity
import uz.ruzibekov.domain.model.entity.starship.StarshipEntity

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorite_starships")
    fun getStarshipList(): List<StarshipEntity>

    @Insert
    fun insertStarship(starshipEntity: StarshipEntity)

    @Query("DELETE FROM favorite_starships WHERE id = :id")
    fun deleteStarshipById(id: Int)


    @Query("SELECT * FROM favorite_personages")
    fun getPersonageList(): List<PersonageEntity>

    @Insert
    fun insertPersonage(personage: PersonageEntity)

    @Query("DELETE FROM favorite_personages WHERE id = :id")
    fun deletePersonageById(id: Int)
}