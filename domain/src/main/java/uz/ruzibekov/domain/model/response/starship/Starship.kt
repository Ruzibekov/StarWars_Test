package uz.ruzibekov.domain.model.response.starship

import uz.ruzibekov.domain.model.entity.StarshipEntity

data class Starship(
    val MGLT: String,
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val films: List<String>,
    val hyperdrive_rating: String,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<String>,
    val starship_class: String,
    val url: String,
)

fun StarshipEntity.toStarship(): Starship {
    return Starship(
        MGLT,
        cargo_capacity,
        consumables,
        cost_in_credits,
        created,
        crew,
        edited,
        films,
        hyperdrive_rating,
        length,
        manufacturer,
        max_atmosphering_speed,
        model,
        name,
        passengers,
        pilots,
        starship_class,
        url
    )
}
