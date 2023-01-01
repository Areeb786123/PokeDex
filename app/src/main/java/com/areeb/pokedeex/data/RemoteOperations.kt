package com.areeb.pokedeex.data

import com.areeb.pokedeex.data.models.PokemonDto
import com.areeb.pokedeex.data.network.remote.api.HomeApi
import com.areeb.pokedeex.data.repository.SafeApiCall
import javax.inject.Inject

class RemoteOperations @Inject constructor(
    private val homeApi: HomeApi
) : IRemoteOperation, SafeApiCall {
    override suspend fun getPokemons(): Resource<PokemonDto> {
        return safeApiCall { homeApi.getPokemon() }
    }
}
