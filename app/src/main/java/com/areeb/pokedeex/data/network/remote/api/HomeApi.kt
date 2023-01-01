package com.areeb.pokedeex.data.network.remote.api

import com.areeb.pokedeex.data.models.PokemonDto
import retrofit2.http.GET

interface HomeApi {

    @GET("pokedex.json")
    suspend fun getPokemon(): PokemonDto
}
