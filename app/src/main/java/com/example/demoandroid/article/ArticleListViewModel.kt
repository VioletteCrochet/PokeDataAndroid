package com.example.demoandroid.article

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ArticleListViewModel: ViewModel() {
    var articles = MutableStateFlow<List<Article>>(
        mutableListOf(
            Article("ytyrt", "a", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Hoste%2C_Église_Saint-Maurice.jpg/280px-Hoste%2C_Église_Saint-Maurice.jpg") ,
            Article("yeeeey", "b","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Hoste%2C_Église_Saint-Maurice.jpg/280px-Hoste%2C_Église_Saint-Maurice.jpg"),
            Article("hellooooo", "c", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Hoste%2C_Église_Saint-Maurice.jpg/280px-Hoste%2C_Église_Saint-Maurice.jpg")
        )
    )
}