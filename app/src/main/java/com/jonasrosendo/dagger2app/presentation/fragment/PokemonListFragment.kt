package com.jonasrosendo.dagger2app.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jonasrosendo.dagger2app.presentation.viewmodel.PokemonListViewModel
import com.jonasrosendo.dagger2app.R
import com.jonasrosendo.dagger2app.presentation.adapter.PokemonAdapter
import kotlinx.android.synthetic.main.pokemon_list_fragment.*
import kotlinx.android.synthetic.main.pokemon_list_fragment.view.*

class PokemonListFragment : Fragment() {

    private lateinit var viewModel: PokemonListViewModel
    private val pokemonAdapter = PokemonAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[PokemonListViewModel::class.java]

        rv_pokemons.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = pokemonAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.pokemonResults.observe(viewLifecycleOwner, Observer {
            pokemonAdapter.update(it)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { loading ->
            if (loading) {
                hideList()
            } else {
                showList()
            }
        })
    }

    fun hideList() {
        rv_pokemons.visibility = View.GONE
        pb_load_list.visibility = View.VISIBLE
    }

    fun showList() {
        pb_load_list.visibility = View.GONE
        rv_pokemons.visibility = View.VISIBLE
    }
}