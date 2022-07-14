package com.example.pokemontrivia.datasource.remote

import com.example.pokemontrivia.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("pokemon")
    suspend fun getAllPokemon(): List<Pokemon>

    @GET("pokemon/{number}")
    suspend fun getPokemonByNumber(@Path("number") number: String): Pokemon
}