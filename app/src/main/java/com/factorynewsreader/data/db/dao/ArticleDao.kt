package com.factorynewsreader.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.factorynewsreader.data.db.entity.ArticleEntity
import io.reactivex.rxjava3.core.Observable

@Dao
interface ArticleDao {

    @Query("SELECT * from articles")
    fun getAll(): Observable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<ArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: ArticleEntity)

    @Update
    fun update(data: ArticleEntity)

    @Delete
    fun delete(data: ArticleEntity)

    @Query("DELETE FROM articles")
    fun deleteAll()
}