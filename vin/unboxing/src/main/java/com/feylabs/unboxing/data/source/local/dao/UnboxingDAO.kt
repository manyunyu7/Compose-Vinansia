package com.feylabs.unboxing.data.source.local.dao

import androidx.room.*
import com.feylabs.unboxing.data.source.local.entity.UnboxingEntity

@Dao
interface UnboxingDAO {

    @Query("SELECT * FROM unboxing_items ORDER BY id DESC")
    fun getAll(): List<UnboxingEntity>?

    @Query("SELECT * FROM unboxing_items WHERE category = :category ORDER BY id DESC")
    fun getAllByCategory(category: String): List<UnboxingEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<UnboxingEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: UnboxingEntity)

    @Query("DELETE FROM unboxing_items WHERE id = :id")
    fun deleteById(id: Int)

    @Query("DELETE FROM unboxing_items where id <> 0")
    fun deleteAll()
}