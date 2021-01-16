package com.factorynewsreader.data.repository

import com.factorynewsreader.App
import com.factorynewsreader.R
import com.factorynewsreader.data.api.ApiService
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.data.db.dao.ArticleDao
import com.factorynewsreader.data.db.preferences.PreferencesManager
import com.factorynewsreader.data.mapper.ArticleMapper
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val application: App,
    private val apiService: ApiService,
    private val articleDao: ArticleDao,
    private val articleMapper: ArticleMapper,
    private val preferencesManager: PreferencesManager
) {

    /**
     * Fetch list of articles
     * @return list of articles
     */
    fun getArticles(): Observable<List<Article>> = when {
        preferencesManager.needsUpdateNewArticles() -> getArticlesFromApi()
        else -> getArticlesFromDatabase()
    }

    /**
     * @return list of articles from API
     */
    private fun getArticlesFromApi(): Observable<List<Article>> =
        apiService.getArticles(apiKey = application.getString(R.string.api_key))
            .doOnNext {
                preferencesManager.setLastUpdatedArticlesTimestamp()
                articleDao.insert(articleMapper.toEntities(it.articles))
            }
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