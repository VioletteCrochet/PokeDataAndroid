package com.example.demoandroid.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class PokemonDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            PokemonScreen(navController = navController);
        }
    }
}

@Composable
fun PokemonScreen(navController: NavController,) {
//    val name by viewModel.name.observeAsState("")
//    val name = viewModel.name.observeAsState("")
//    val desc = viewModel.desc.observeAsState("")
//    val img = viewModel.img.observeAsState("")
//
//
//    MyPage(navController) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = name.value, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.height(8.dp))
//            Image(
//                painter = rememberAsyncImagePainter(img.value),
//                contentDescription = name.value,
//                modifier = Modifier.size(200.dp)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = desc.value, fontSize = 16.sp, textAlign = TextAlign.Center)
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    val navController = rememberNavController()
    PokemonScreen(navController);
}