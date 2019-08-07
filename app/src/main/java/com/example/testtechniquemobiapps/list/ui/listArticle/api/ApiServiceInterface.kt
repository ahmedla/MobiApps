package com.example.testtechniquemobiapps.list.ui.listArticle.api

import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Body
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceInterface {

    @GET("articlesearch.json")
    fun getArticlesAsync(): Deferred<Response<Body>>
}