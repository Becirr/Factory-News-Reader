package com.factorynewsreader.data.repository

import android.app.Application
import com.factorynewsreader.R
import com.factorynewsreader.data.api.ApiService
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.data.db.dao.ArticleDao
import com.factorynewsreader.data.mapper.ArticleMapper
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val application: Application,
    private val apiService: ApiService,
    private val articleDao: ArticleDao,
    private val articleMapper: ArticleMapper
) {

    /**
     * Fetch list of articles
     * @param forceRemote if true list of articles will be loaded from API
     * @return list of articles
     */
    fun getArticles(
        forceRemote: Boolean = false
    ): Observable<List<Article>> = when {
        forceRemote -> getArticlesFromApi()
        else -> getArticlesFromDatabase()
    }

    /**
     * @return list of articles from API
     */
    private fun getArticlesFromApi(): Observable<List<Article>> =
        apiService.getArticles(apiKey = application.getString(R.string.api_key))
            .doOnNext { articleDao.insert(articleMapper.toEntities(it.articles)) }
            .doOnNext { Timber.d("Data loaded from API!") }
            .map { it.articles }

    /**
     * @return list of articles from local database, if list is empty then try to fetch from API
     */
    private fun getArticlesFromDatabase(): Observable<List<Article>> = articleDao.getAll()
        .map { articleMapper.toModels(it) }
        .doOnNext { Timber.d("Data loaded from local database!") }
        .flatMap {
            if (it.isEmpty()) getArticlesFromApi()
            else Observable.just(it)
        }
}