package com.example.demoandroid.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.R
import com.example.demoandroid.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleListViewModel(application: Application): AndroidViewModel(application) {
    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    /**
     * *Fonction qui recherge la liste des personnes dans le view model
     */
    fun reloadArticles() {

        val message = getApplication<Application>().getString(R.string.app_dialog_loading_articles)

        AppDialogHelpers.get().showDialog(message)

        viewModelScope.launch { // tâche async
            delay(1000)

            val apiResponse = ArticleService.ArticleApi.articleService.getArticles()

            AppDialogHelpers.get().closeDialog()

            // TODO : Afficher le message popup
            println(apiResponse.message)

            // Tester si OK : 200
            if (apiResponse.code.equals("200")){
                articles.value = apiResponse.data!!
            }
        }
    }
}