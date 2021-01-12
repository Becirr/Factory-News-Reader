package com.factorynewsreader.data.api

import com.factorynewsreader.data.api.model.ArticlesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("articles")
    fun getArticles(
        @Query("source") source: String = "bbc-news",
        @Query("sortBy") sortBy: String = "top",
        @Query("apiKey") apiKey: String
    ): Observable<ArticlesResponse>
}