package uz.ruzibekov.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.domain.model.entity.StarshipEntity

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorite_starships")
    fun getStarshipList(): List<StarshipEntity>

    @Insert
    fun insertStarship(starshipEntity: StarshipEntity)

    @Query("DELETE FROM favorite_starships WHERE id = :id")
    fun deleteById(id: Int)
}