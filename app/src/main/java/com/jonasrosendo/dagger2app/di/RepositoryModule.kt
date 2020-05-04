package com.jonasrosendo.dagger2app.di

import com.jonasrosendo.dagger2app.data.PokemonRepository
import com.jonasrosendo.dagger2app.data.PokemonService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(pokemonService: PokemonService) = PokemonRepository(pokemonService)
}