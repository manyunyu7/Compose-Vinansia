package com.feylabs.unboxing.data.source.local.dao

import androidx.room.*
import com.feylabs.unboxing.data.source.local.entity.SnipsEntity

@Dao
interface SnipsDAO {

    @Query("SELECT * FROM snips_items ORDER BY id DESC")
    fun getAll(): List<SnipsEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<SnipsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: SnipsEntity)

    @Query("DELETE FROM snips_items WHERE id = :id")
    fun deleteById(id: Int)

    @Query("DELETE FROM snips_items where id <> 0")
    fun deleteAll()
}