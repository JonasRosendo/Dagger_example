package com.jonasrosendo.dagger2app.domain


import com.google.gson.annotations.SerializedName

data class PokemonResult(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)