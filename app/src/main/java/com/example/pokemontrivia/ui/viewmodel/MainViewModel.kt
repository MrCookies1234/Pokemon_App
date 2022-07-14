package com.example.pokemontrivia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemontrivia.model.Pokemon
import com.example.pokemontrivia.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    private val _selectedPokemon = MutableStateFlow<Pokemon?>(null)
    val selectedPokemon = _selectedPokemon.asStateFlow()

    init {
        viewModelScope.launch {
            _selectedPokemon.value = pokemonRepository.getPokemonByNumber("4")
        }
    }
}