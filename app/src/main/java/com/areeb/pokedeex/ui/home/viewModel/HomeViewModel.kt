package com.areeb.pokedeex.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.areeb.pokedeex.data.Resource
import com.areeb.pokedeex.data.models.Pokemon
import com.areeb.pokedeex.data.models.PokemonDto
import com.areeb.pokedeex.data.repository.home.HomeRepository
import com.areeb.pokedeex.ui.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : BaseViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            setResourceStatus(Resource.Loading(true))
            repository.getPokemons()
                .catch { exceptions ->
                    setResourceError(exceptions.toString())
                }
                .collect { setResponse(it) }
        }
    }

    private fun setResponse(pokemonResponse: Resource<PokemonDto>) {
        setResourceStatus(pokemonResponse)
        if (pokemonResponse is Resource.Success) {
            Log.e("dataAreeb", pokemonResponse.data.pokemon.toString())
            _pokemonList.value = pokemonResponse.data.pokemon
        }
    }
}
