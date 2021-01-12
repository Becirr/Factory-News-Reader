package com.factorynewsreader.data.api.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("sortBy")
    val sortBy: String,
    @SerializedName("articles")
    val articles: List<Article> = listOf()
)