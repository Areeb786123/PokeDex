package com.areeb.pokedeex.data.network.remote.api

import com.areeb.pokedeex.data.models.PokemonDto
import com.areeb.pokedeex.data.models.ResultDto
import retrofit2.http.GET

interface HomeApi {

    @GET("pokemon")
    suspend fun getPokemon(): PokemonDto
}
