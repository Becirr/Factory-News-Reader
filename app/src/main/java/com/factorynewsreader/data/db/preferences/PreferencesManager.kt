package com.factorynewsreader.data.db.preferences

import android.content.Context
import android.content.SharedPreferences
import com.factorynewsreader.App
import com.factorynewsreader.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(application: App) : IPreferencesManager {

    companion object {
        private const val PREF_KEY_LAST_UPDATED_ARTICLES_TIMESTAMP =
            "PREF_KEY_LAST_UPDATED_ARTICLES_TIMESTAMP"
    }

    private val sharedPreferences: SharedPreferences = application.getSharedPreferences(
        application.getString(R.string.preferences_name),
        Context.MODE_PRIVATE
    )

    override fun setLastUpdatedArticlesTimestamp() {
        sharedPreferences.edit()
            .putLong(PREF_KEY_LAST_UPDATED_ARTICLES_TIMESTAMP, System.currentTimeMillis())
            .apply()
    }

    override fun needsUpdateNewArticles(): Boolean {
        val timestamp = sharedPreferences.getLong(PREF_KEY_LAST_UPDATED_ARTICLES_TIMESTAMP, 0L)
        return timestamp == 0L || ((System.currentTimeMillis() - timestamp) >= 5 * 60 * 1000)
    }

}
