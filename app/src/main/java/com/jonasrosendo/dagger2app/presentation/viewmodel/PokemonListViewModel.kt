package com.jonasrosendo.dagger2app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonasrosendo.dagger2app.data.PokemonRepository
import com.jonasrosendo.dagger2app.di.DaggerPokemonListViewModelComponent
import com.jonasrosendo.dagger2app.di.RepositoryModule
import com.jonasrosendo.dagger2app.domain.PokemonResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val pokemonResults = MutableLiveData<List<PokemonResult>>()
    val isLoading = MutableLiveData<Boolean>()
    @Inject
    lateinit var repository: PokemonRepository

    init {
        DaggerPokemonListViewModelComponent
            .builder()
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)

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