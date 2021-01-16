package com.factorynewsreader.data.db.preferences

interface IPreferencesManager {
    fun setLastUpdatedArticlesTimestamp()
    fun needsUpdateNewArticles(): Boolean
}