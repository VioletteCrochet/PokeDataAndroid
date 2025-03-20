package com.example.demoandroid.article

import com.example.demoandroid.api.ResponseAPI
import com.example.demoandroid.api.RetrofitTools.Companion.retrofit
import com.example.demoandroid.demostateful.Person
import retrofit2.http.GET

interface ArticleService {

    @GET("articles")
    suspend fun getArticles() : ResponseAPI<List<Article>>

    object ArticleApi {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }

}