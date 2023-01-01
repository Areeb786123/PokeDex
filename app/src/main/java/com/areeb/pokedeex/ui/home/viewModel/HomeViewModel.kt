package com.areeb.pokedeex.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.areeb.pokedeex.data.Resource
import com.areeb.pokedeex.data.models.PokemonDto
import com.areeb.pokedeex.data.models.ResultDto
import com.areeb.pokedeex.data.repository.home.HomeRepository
import com.areeb.pokedeex.ui.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : BaseViewModel() {

    private val _pokemons = MutableLiveData<List<ResultDto>>()
    val pokemons: LiveData<List<ResultDto>>
        get() = _pokemons

    init {
        getPokemons()
    }

    private fun getPokemons() {
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
            Log.e("dataAreeb", pokemonResponse.data.results.toString())
            _pokemons.value = pokemonResponse.data.results
        }
    }
}
