package uz.ruzibekov.domain.model.response.starship

import com.google.gson.annotations.SerializedName

data class StarshipBaseResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Any,
    @SerializedName("pervious") val previous: Any,
    @SerializedName("results") val starships: List<Starship>
)