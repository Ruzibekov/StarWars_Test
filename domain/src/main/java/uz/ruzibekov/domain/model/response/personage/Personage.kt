package uz.ruzibekov.domain.model.response.personage

import uz.ruzibekov.domain.model.entity.personage.PersonageEntity

data class Personage(
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
){
    var isFavorite: Boolean = false
}

fun PersonageEntity.toPersonage(): Personage {
    return Personage(
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