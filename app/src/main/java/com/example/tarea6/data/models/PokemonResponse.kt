package com.example.tarea6.data.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int? = null,
    val name: String? = null,
    @SerializedName("base_experience")
    val baseExperience: Int? = null,
    val sprites: PokemonSprites? = null,
    val abilities: List<PokemonAbilitySlot>? = null,
    val cries: PokemonCries? = null
)

data class PokemonSprites(
    @SerializedName("front_default")
    val frontDefault: String? = null,
    val other: PokemonOtherSprites? = null
)

data class PokemonOtherSprites(
    @SerializedName("official-artwork")
    val officialArtwork: PokemonOfficialArtwork? = null
)

data class PokemonOfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String? = null
)

data class PokemonAbilitySlot(
    val ability: PokemonAbilityInfo? = null,
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null
)

data class PokemonAbilityInfo(
    val name: String? = null,
    val url: String? = null
)

data class PokemonCries(
    val latest: String? = null,
    val legacy: String? = null
)
