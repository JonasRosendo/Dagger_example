package com.jonasrosendo.dagger2app.data

import com.google.gson.GsonBuilder
import com.jonasrosendo.dagger2app.domain.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonService: PokemonApi{

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(PokemonApi::class.java)

    override suspend fun getPokemons(): PokemonResponse {
        return api.getPokemons()
    }
}