package com.jonasrosendo.dagger2app.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonasrosendo.dagger2app.R
import com.jonasrosendo.dagger2app.domain.PokemonResult
import kotlinx.android.synthetic.main.item_pokemon_list.view. *

class PokemonAdapter(private val pokemonResults: ArrayList<PokemonResult>):
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pokemon_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonResults.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemonResults[position])
    }

    fun update(newPokemonsResults: List<PokemonResult>) {
        pokemonResults.clear()
        pokemonResults.addAll(newPokemonsResults)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.tv_pokemon_name

        fun bind(pokemonResult: PokemonResult) {
            name.text = pokemonResult.name
        }
    }
}