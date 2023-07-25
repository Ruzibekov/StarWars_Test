package uz.ruzibekov.domain.model.response.personage

import com.google.gson.annotations.SerializedName

data class PersonagesBaseResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Any,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val personages: List<Personage>
)