package com.areeb.pokedeex.data

import com.areeb.pokedeex.data.models.PokemonDto

interface IRemoteOperation {
    suspend fun getPokemons(): Resource<PokemonDto>
}
