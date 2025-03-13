package com.example.demoandroid.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.rememberAsyncImagePainter
import com.example.demoandroid.ui.theme.MyPage

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