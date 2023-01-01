package com.areeb.pokedeex.data.repository.home

import com.areeb.pokedeex.data.RemoteOperations
import com.areeb.pokedeex.data.Resource
import com.areeb.pokedeex.data.models.PokemonDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remoteOperations: RemoteOperations
) {
    fun getPokemons(): Flow<Resource<PokemonDto>> {
        return flow {
            val pokemonResponse = remoteOperations.getPokemons()
            emit(pokemonResponse)
        }.flowOn(Dispatchers.IO)
    }
}
