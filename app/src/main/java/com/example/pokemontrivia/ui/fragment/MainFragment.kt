package com.example.pokemontrivia.ui.fragment

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemontrivia.R
import com.example.pokemontrivia.databinding.FragmentMainBinding
import com.example.pokemontrivia.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_main)
        subscribeToObservables()
    }

    private fun subscribeToObservables(){
        lifecycleScope.launch {
            viewModel.selectedPokemon.collectLatest { selectedPokemon ->
                binding.pokemonNameTextview.text = selectedPokemon?.name
            }
        }
    }

}