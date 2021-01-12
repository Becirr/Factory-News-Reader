package com.factorynewsreader.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    val author: String,
    @PrimaryKey
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)