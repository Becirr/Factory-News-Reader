package com.factorynewsreader.data.mapper

import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.data.db.entity.ArticleEntity
import javax.inject.Inject

class ArticleMapper @Inject constructor() {

    fun toEntities(data: List<Article>) = data.map { toEntity(it) }

    fun toEntity(data: Article) = ArticleEntity(
        author = data.author,
        title = data.title,
        description = data.description,
        url = data.url,
        urlToImage = data.urlToImage
    )

    fun toModels(data: List<ArticleEntity>) = data.map { toModel(it) }

    fun toModel(data: ArticleEntity) = Article(
        author = data.author,
        title = data.title,
        description = data.description,
        url = data.url,
        urlToImage = data.urlToImage
    )
}