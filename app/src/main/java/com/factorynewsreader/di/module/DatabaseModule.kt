package com.factorynewsreader.di.module

import androidx.room.Room
import com.factorynewsreader.App
import com.factorynewsreader.R
import com.factorynewsreader.data.db.NewsFactoryDatabase
import com.factorynewsreader.data.db.dao.ArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule constructor(private val app: App) {

    @Singleton
    @Provides
    fun providesArticleDatabase(): NewsFactoryDatabase =
        Room.databaseBuilder(
            app,
            NewsFactoryDatabase::class.java,
            app.getString(R.string.database_name)
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun providesArticleDao(newsFactoryDatabase: NewsFactoryDatabase): ArticleDao =
        newsFactoryDatabase.articleDao()
}