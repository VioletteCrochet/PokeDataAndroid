package com.example.demoandroid.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demoandroid.LoginActivity
import com.example.demoandroid.LoginForm
import com.example.demoandroid.RegisterActivity
import com.example.demoandroid.pokemon.PokedexActivity

sealed class Activity(val route: String) {
    object Home : Activity("home")
    object PokemonList : Activity("pokemon_list")
    object Login : Activity("login")
    object Signup : Activity("signup")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Activity.Home.route) {
        composable(Activity.Home.route) { LoginActivity(navController) }
        composable(Activity.PokemonList.route) { PokedexActivity(navController) }
        composable(Activity.Login.route) { LoginActivity(navController }
        composable(Activity.Signup.route) { RegisterActivity(navController }
    }
}