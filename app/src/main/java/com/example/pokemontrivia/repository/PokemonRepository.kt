package com.example.pokemontrivia.repository

import com.example.pokemontrivia.model.Pokemon

interface PokemonRepository {

    suspend fun getAllPokemon() : List<Pokemon>
    suspend fun getPokemonByNumber(number : String) : Pokemon
}