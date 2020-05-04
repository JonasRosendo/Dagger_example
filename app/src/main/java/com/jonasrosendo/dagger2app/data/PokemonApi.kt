package com.jonasrosendo.dagger2app.data

import com.jonasrosendo.dagger2app.domain.PokemonResponse
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemons(): PokemonResponse
}