package com.example.demoandroid.nav

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Pokedex : Screen("pokedex")
    object Login : Screen("login")
    object Register : Screen("register")
}

//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = Screen.Home.route) {
//        composable(Screen.Home.route) { LoginScreen(navController) }
//        composable(Screen.Pokedex.route) { PokedexScreen(navController) }
//        composable(Screen.Login.route) { LoginScreen(navController) }
//        composable(Screen.Register.route) { RegisterScreen(navController) }
//        composable(Screen.Register.route) { PokemonScreen(navController) }
//    }
//}