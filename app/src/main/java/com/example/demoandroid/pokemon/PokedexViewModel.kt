package com.example.demoandroid.pokemon

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PokedexViewModel : ViewModel() {
    var pokemons = MutableStateFlow<List<Pokemon>>(mutableListOf(
        Pokemon(name = "Pikachu", desc = "Un Pokémon électrique très populaire.", img = "https://img.pokemondb.net/sprites/black-white/normal/pikachu-f.png"),
        Pokemon(name = "Bulbizarre", desc = "Un Pokémon plante/poison avec une graine sur son dos.",img = "https://img.pokemondb.net/sprites/black-white/normal/charmander.png"),
        Pokemon(name ="Salamèche", desc = "Un Pokémon de type feu avec une flamme sur sa queue.", img = "https://img.pokemondb.net/sprites/black-white/normal/bulbasaur.png"),
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

