package com.jonasrosendo.dagger2app.data

class PokemonRepository(private val api: PokemonService) {
    suspend fun getPokemons() = api.getPokemons()
}