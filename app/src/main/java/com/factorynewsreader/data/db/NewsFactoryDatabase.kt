package com.factorynewsreader.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.factorynewsreader.data.db.dao.ArticleDao
import com.factorynewsreader.data.db.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsFactoryDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}