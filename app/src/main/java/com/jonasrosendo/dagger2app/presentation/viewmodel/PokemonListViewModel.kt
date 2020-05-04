package com.jonasrosendo.dagger2app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonasrosendo.dagger2app.data.PokemonRepository
import com.jonasrosendo.dagger2app.data.PokemonService
import com.jonasrosendo.dagger2app.domain.PokemonResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val api = PokemonService()
    private val repository = PokemonRepository(api)
    val pokemonResults = MutableLiveData<List<PokemonResult>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getPokemons()
    }

    private fun getPokemons() {
        coroutineScope.launch {
            isLoading.postValue(true)
            val pokemonResponse = repository.getPokemons()
            withContext(Dispatchers.Main) {
                pokemonResults.value = pokemonResponse.results
                isLoading.value = false
            }
        }
    }

}