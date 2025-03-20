package com.example.demoandroid.article

import com.example.demoandroid.demoapi.RetrofitTools.Companion.retrofit
import com.example.demoandroid.demostateful.Person
import retrofit2.http.GET

interface ArticleService {

    @GET("android-articles.json")
    suspend fun getArticles() : List<Article>

    // Pourra être accessible via cet appel : PersonApi.personService
    object ArticleApi {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }

}