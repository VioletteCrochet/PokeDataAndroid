package com.example.demoandroid.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoandroid.ui.theme.MyPage

class PokemonDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonDisplay();
        }
    }
}

@Composable
fun PokemonDisplay() {
    MyPage {}
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    PokemonDisplay();
}