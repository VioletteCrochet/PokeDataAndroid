package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.MyTextField
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class ResetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ResetPasswordScreen(navController)
        }
    }
}

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    val context = LocalContext.current
    MyPage () {
        Column(modifier = Modifier.padding(20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Row (){
                Text(
                    text = "Recover password",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)
                        .fillMaxWidth(),
                    color = Color(0xFFF5F5F5),
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
            Row {
                WrapPaddingRowWeight { MyTextField(hintText = "Email") }
            }
            Row {
                WrapPaddingRowWeight { MyButton("Send Link",) }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordPreview() {
    val navController = rememberNavController()
    ResetPasswordScreen(navController);
}