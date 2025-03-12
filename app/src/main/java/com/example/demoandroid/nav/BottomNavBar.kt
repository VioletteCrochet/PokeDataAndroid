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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

class BottomNavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavBar();
        }
    }
}
@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(Activity.Home, Activity.PokemonList, Activity.Login, Activity.Signup)

    NavigationBar {  // Si Material 3 : remplacer par NavigationBar
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { activity ->
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = activity.route) },
                label = { Text(activity.route) },
                selected = currentRoute == activity.route,
                onClick = {
                    navController.navigate(activity.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar();
}