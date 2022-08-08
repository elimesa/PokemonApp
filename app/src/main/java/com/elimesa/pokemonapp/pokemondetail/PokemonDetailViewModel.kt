package com.elimesa.pokemonapp.pokemondetail

import androidx.lifecycle.ViewModel
import com.elimesa.pokemonapp.data.remote.responses.Pokemon
import com.elimesa.pokemonapp.repository.PokemonRepository
import com.elimesa.pokemonapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}