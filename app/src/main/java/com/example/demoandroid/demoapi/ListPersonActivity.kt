package com.example.demoandroid.demoapi

//import com.example.demoandroid.nav.NavigationGraph
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.demoandroid.demostateful.Person
import com.example.demoandroid.ui.theme.MyButton
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class DemoViewModelActivity() : ComponentActivity() {

    var viewModel = ListPersonViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListPersonScreen(viewModel)
        }
    }
}

@Composable
fun ListPersonScreen(viewModel: ListPersonViewModel) {
    val context = LocalContext.current

    val personsState by viewModel.persons.collectAsState()
    MyPage {
        Column(modifier = Modifier.padding(30.dp)) {
                LazyColumn {
                    items(personsState) { person ->
                        Text(
                            text = "pseudo : ${person.pseudo}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White, fontWeight = FontWeight.Bold
                        )
                    }
                }

            Row {
                WrapPaddingRowWeight {
                    MyButton(buttonText = "Refresh View", onClick = {
                        viewModel.relaodPersons()
                    })
                }
            }
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun ListPersonPreview() {
    var viewModel = ListPersonViewModel()
    ListPersonScreen(viewModel)
}