package com.example.demoandroid.article

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.demoandroid.R
import com.example.demoandroid.ui.theme.MyPage
import com.example.demoandroid.ui.theme.WrapPadding

class DemoViewModelActivity() : ComponentActivity() {

    var viewModel = ArticleListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleListViewModelScreen(viewModel)
        }
    }
}

@Composable
fun ArticleListViewModelScreen(viewModel: ArticleListViewModel) {
    val context = LocalContext.current

    val articlesState by viewModel.articles.collectAsState()
    MyPage {
        Column(modifier = Modifier.padding(30.dp)) {
            LazyColumn {
                items(articlesState) { article ->
                    WrapPadding {
                        ElevatedCard() {
                            Row(modifier = Modifier.padding(vertical = 10.dp)) {
                                AsyncImage(
                                    model = "https://picsum.photos/id/237/200/300",
                                    placeholder = painterResource(R.drawable.placholder_img),
                                    contentDescription = "erthgnfbdstryjhg",
                                    modifier = Modifier.width(96.dp),
                                    contentScale = ContentScale.Crop)
                                Column {
                                    Text(
                                        text = article.title,
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.Black, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = article.desc,
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.Black,
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}



@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun ArticleListViewModelPreview() {
    var viewModel = ArticleListViewModel()
    ArticleListViewModelScreen(viewModel)
}