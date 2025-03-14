package com.example.demoandroid.demostateful

//import com.example.demoandroid.nav.NavigationGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight
import kotlinx.coroutines.flow.MutableStateFlow

class DemoStateful2Activity() : ComponentActivity() {

    var person = MutableStateFlow<Person>(Person(pseudo = "Pain au chocolat", age = 32))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStateful2Screen(person)
        }
    }
}

@Composable
fun DemoStateful2Screen(person: MutableStateFlow<Person>) {
    val context = LocalContext.current

    val personState by person.collectAsState()
    MyPage {
        Column(modifier = Modifier.padding(30.dp)) {
            Row {
                WrapPaddingRowWeight {
                    Text(
                        text = "pseudo : ${personState.pseudo}",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White, fontWeight = FontWeight.Bold
                    )
                }
            }

            Row {
                WrapPaddingRowWeight {
                    MyButton(buttonText = "change pseudo", onClick = {
                        person.value = person.value.copy(pseudo = "aleed", age = 44)
                    })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DemoStateful2Preview() {
    var person = MutableStateFlow<Person>(Person(pseudo = "Pain au chocolat", age = 32))
    DemoStateful2Screen(person)
}