package com.example.demoandroid.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController();

//    NavHost(navController = navController, startDestination = "login") {
//        composable(Screen.Home.route) { LoginScreen(navController) }
//        composable(Screen.Pokedex.route) { PokedexScreen(navController) }
//        composable(Screen.Login.route) { LoginScreen(navController) }
//        composable(Screen.Register.route) { RegisterScreen(navController) }
//    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    MainScreen()
}
