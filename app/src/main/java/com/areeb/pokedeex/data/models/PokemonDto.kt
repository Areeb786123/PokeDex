package com.areeb.pokedeex.data.models

data class PokemonDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultDto>
)