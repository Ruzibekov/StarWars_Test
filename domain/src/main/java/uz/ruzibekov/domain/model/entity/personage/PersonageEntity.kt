package uz.ruzibekov.domain.model.entity.personage

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.ruzibekov.domain.model.response.personage.Personage

@Entity(tableName = "favorite_personages")
data class PersonageEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val films: List<String>,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val skin_color: String,
    val species: List<String>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>,
)

fun Personage.toPersonageEntity(): PersonageEntity {
    return PersonageEntity(
        id = 0,
        birth_year,
        created,
        edited,
        eye_color,
        films,
        gender,
        hair_color,
        height,
        homeworld,
        mass,
        name,
        skin_color,
        species,
        starships,
        url,
        vehicles
    )
}