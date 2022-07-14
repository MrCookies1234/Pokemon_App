package com.example.pokemontrivia.repository

import com.example.pokemontrivia.datasource.remote.PokemonAPI
import com.example.pokemontrivia.model.Pokemon
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(private val api : PokemonAPI) : PokemonRepository {

    override suspend fun getAllPokemon(): List<Pokemon> {
        return api.getAllPokemon()
    }

    override suspend fun getPokemonByNumber(number: String): Pokemon {
        return api.getPokemonByNumber(number)
    }
}