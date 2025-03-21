package com.example.demoandroid.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.ui.theme.MyPage

class DemoNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoNavScreen()
        }
    }
}

@Composable
fun DemoNavScreen() {
    val navController = rememberNavController();
    NavHost(
        navController = navController,
        startDestination = "page1"
    ) {
        composable(route = "page1"){
            Column {
                Text("Page 1")
                ElevatedButton(onClick = {
                    navController.navigate("page2")
                }) { Text("Ouvrir page 2") }
            }
        }
        composable("Page2") {
            Page2(navController)
        }
    }

}

@Composable
fun Page2(navController: NavHostController) {
    MyPage {
        Column {
            Text("page 2")
            ElevatedButton(onClick = {
                navController.navigate("page1")
            }) { Text("Ouvrir page 2") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    DemoNavScreen()
}
