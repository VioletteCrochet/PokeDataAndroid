package com.example.demoandroid.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.LoginActivity
import com.example.demoandroid.RegisterActivity
import com.example.demoandroid.ResetPasswordScreen
import com.example.demoandroid.helpers.AppViewHelper
import com.example.demoandroid.pokemon.PokedexActivity

class BottomNavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            BottomNavBar(navController)
        }
    }
}
@Composable
fun BottomNavBar(navController: NavHostController) {
    val context = LocalContext.current
    val items = listOf(Screen.Home, Screen.Pokedex, Screen.Login, Screen.Register)

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = Screen.Home.route) },
            label = { Text(Screen.Home.route) },
            selected = currentRoute == "home",
            onClick = { AppViewHelper.openActivity(context, LoginActivity::class) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = Screen.Pokedex.route) },
            label = { Text(Screen.Pokedex.route) },
            selected = currentRoute == "pokedex",
            onClick = { AppViewHelper.openActivity(context, PokedexActivity::class) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = Screen.Login.route) },
            label = { Text(Screen.Login.route) },
            selected = currentRoute == "login",
            onClick = { AppViewHelper.openActivity(context, LoginActivity::class) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = Screen.Register.route) },
            label = { Text(Screen.Register.route) },
            selected = currentRoute == "register",
            onClick = { AppViewHelper.openActivity(context, RegisterActivity::class) }
        )

    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BottomNavBar(navController)
}