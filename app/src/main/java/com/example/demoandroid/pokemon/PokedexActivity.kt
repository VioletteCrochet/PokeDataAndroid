package com.example.demoandroid.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.R
import com.example.demoandroid.nav.BottomNavBar
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.PokemonCard
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class PokedexActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexDisplay();
        }
    }
}

@Composable
fun PokedexDisplay() {
    MyPage {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            val pokemons = listOf(
                Pokemon(name = "Pikachu", "Un Pokémon électrique très populaire.", "https://img.pokemondb.net/sprites/black-white/normal/pikachu-f.png"),
                Pokemon("Bulbizarre", "Un Pokémon plante/poison avec une graine sur son dos.", "https://img.pokemondb.net/sprites/black-white/normal/bulbasaur.png"),
                Pokemon("Salamèche", "Un Pokémon de type feu avec une flamme sur sa queue.", "https://img.pokemondb.net/sprites/black-white/normal/bulbasaur.png"),
                /*Pokemon("Carapuce", "Un Pokémon eau avec une carapace protectrice.", R.drawable.),
                Pokemon("Dracaufeu", "Une puissante évolution de Salamèche avec des ailes.", R.drawable.),
                Pokemon("Ronflex", "Un Pokémon paresseux qui adore dormir.", R.drawable.),
                Pokemon("Mewtwo", "Un Pokémon légendaire créé par des expériences scientifiques.", R.drawable.),
                Pokemon("Evoli", "Un Pokémon capable d'évoluer en plusieurs formes différentes.", R.drawable.),
                Pokemon("Lucario", "Un Pokémon combat/acier capable de sentir l’aura.", R.drawable.),
                Pokemon("Gardevoir", "Un Pokémon psy/fee capable de prédire l’avenir.", R.drawable.),*/
                Pokemon(name = "Carchacrok", "Il vole à la vitesse d'un avion de chasse et ne laisse jamais sa proie s'échapper.", "https://img.pokemondb.net/sprites/black-white/normal/garchomp-f.png")
            )
            pokemons.chunked(2).forEach { rowPokemons ->
                Row {
                    rowPokemons.forEach { pokemon ->
                        WrapPaddingRowWeight {
                            PokemonCard(pokemon)
                        }
                    }
                    if (rowPokemons.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexPreview() {
    PokedexDisplay();
}