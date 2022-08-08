package com.elimesa.pokemonapp.repository

import com.elimesa.pokemonapp.data.remote.PokeApi
import com.elimesa.pokemonapp.data.remote.responses.Pokemon
import com.elimesa.pokemonapp.data.remote.responses.PokemonList
import com.elimesa.pokemonapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import java.time.ZoneOffset
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api : PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e:Exception){
            return Resource.Error("an unknown error ocurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e:Exception){
            return Resource.Error("an unknown error ocurred")
        }
        return Resource.Success(response)
    }
}