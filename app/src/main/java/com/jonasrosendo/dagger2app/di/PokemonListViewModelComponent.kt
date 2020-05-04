package com.jonasrosendo.dagger2app.di

import com.jonasrosendo.dagger2app.presentation.viewmodel.PokemonListViewModel
import dagger.Component

@Component(modules = [PokemonServiceModule::class, RepositoryModule::class])
interface PokemonListViewModelComponent {

    fun inject(pokemonListViewModel: PokemonListViewModel)
}