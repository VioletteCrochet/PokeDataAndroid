package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import com.example.demoandroid.pokemon.PokedexDisplay
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexDisplay();
        }
    }
}

@Composable
fun RegistrationForm() {
    MyPage {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Row (){
                Text(
                    text = "Personal Details",
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    color = Color(0xFFF5F5F5),
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = "First Name") }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = "Last Name") }
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = "Email") }
            }
            Row {
                Text(text = "Téléphone", modifier = Modifier.padding(horizontal = 8.dp), color = Color.LightGray)
            }
            Row {

                WrapPaddingRowWeight(weight = 1f) { MyTextField() }
                WrapPaddingRowWeight(weight = 2f) {
                    MyTextField()
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                WrapPaddingRowWeight { MyTextField(hintText = "DD") }
                WrapPaddingRowWeight { MyTextField(hintText = "MM") }
                WrapPaddingRowWeight { MyTextField(hintText = "YYYY") }

            }
            Row {
                WrapPaddingRowWeight { MyButton("Back") }
                WrapPaddingRowWeight { MyButton("Next") }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexDisplay();
}
