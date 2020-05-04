package com.jonasrosendo.dagger2app.di

import com.jonasrosendo.dagger2app.data.PokemonService
import dagger.Module
import dagger.Provides

@Module
class PokemonServiceModule {

    @Provides
    fun provideService() = PokemonService()
}