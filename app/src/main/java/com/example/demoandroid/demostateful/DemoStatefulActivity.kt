package com.example.demoandroid.demostateful

//import com.example.demoandroid.nav.NavigationGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.WrapPadding
import kotlinx.coroutines.flow.MutableStateFlow

class DemoStatefulActivity() : ComponentActivity() {

    var counter = MutableStateFlow<Int>(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStatefulScreen(counter)
        }
    }
}

@Composable
fun DemoStatefulScreen(counter: MutableStateFlow<Int>) {
    val context = LocalContext.current

    val counterState by counter.collectAsState()
    MyPage() {
        Column(modifier = Modifier.padding(30.dp)) {

            WrapPadding {
                Text(
                    text = "Compteur : ${counterState}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White, fontWeight = FontWeight.Bold
                )
            }
        }
        WrapPadding {
            MyButton(buttonText = "plus 1", onClick = {
                counter.value += 1

            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DemoStatefulPreview() {
    val counter = MutableStateFlow<Int>(0)
    DemoStatefulScreen(counter)
}