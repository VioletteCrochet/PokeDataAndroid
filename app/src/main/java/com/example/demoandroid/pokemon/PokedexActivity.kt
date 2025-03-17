package com.example.demoandroid.pokemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.demostateful.Person
import com.example.demoandroid.ui.theme.MyButton
//import com.example.demoandroid.nav.NavigationGraph
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.PokemonCard
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight


class PokedexActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = PokedexViewModel()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val navController = rememberNavController()
            PokedexScreen(viewModel)
        }
    }
}

@Composable
fun PokedexScreen(viewModel: PokedexViewModel) {
    val context = LocalContext.current
    val pokemonsState by viewModel.pokemons.collectAsState();

    MyPage () {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            LazyColumn {
                items(pokemonsState) { pokemon ->
                    Row {
                        WrapPaddingRowWeight {
                            PokemonCard(pokemon)
                        }
                    }
                }
            }
            Row {
                WrapPaddingRowWeight {
                    MyButton(buttonText = "add Carchacrock", onClick = {
                        viewModel.pokemons.value += Pokemon("Crachacrock", desc = "bravo carchacrock tu es vraiment le meilleur et le plus beau <3", img ="https://img.pokemondb.net/sprites/black-white/normal/garchomp-f.png")
                    })
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PokedexPreview() {
    val navController = rememberNavController()
    var viewModel = PokedexViewModel()
    PokedexScreen(viewModel)
}