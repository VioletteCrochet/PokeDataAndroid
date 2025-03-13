package com.example.demoandroid.pokemon

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PokedexViewModel : ViewModel() {
    var pokemons = MutableStateFlow(listOf(
        Pokemon(name = "Pikachu", "Un Pokémon électrique très populaire.", "https://img.pokemondb.net/sprites/black-white/normal/pikachu-f.png"),
        Pokemon("Bulbizarre", "Un Pokémon plante/poison avec une graine sur son dos.", "https://img.pokemondb.net/sprites/black-white/normal/bulbasaur.png"),
        Pokemon("Salamèche", "Un Pokémon de type feu avec une flamme sur sa queue.", "https://img.pokemondb.net/sprites/black-white/normal/bulbasaur.png"),
    ));



    fun addPokemon(pokemon: Pokemon) {
        pokemons.value = pokemons.value + pokemon

    }
}

data class Pokemon(
    val name: String,
    val desc: String,
    val img: String
)

