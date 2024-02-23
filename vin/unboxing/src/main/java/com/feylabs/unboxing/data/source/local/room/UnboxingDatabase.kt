package com.feylabs.unboxing.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.feylabs.unboxing.data.source.local.dao.SnipsDAO
import com.feylabs.unboxing.data.source.local.dao.UnboxingDAO
import com.feylabs.unboxing.data.source.local.entity.SnipsEntity
import com.feylabs.unboxing.data.source.local.entity.UnboxingEntity

@Database(
    entities = [SnipsEntity::class, UnboxingEntity::class], version = 169
)
abstract class UnboxingDatabase : RoomDatabase() {
    abstract fun snipsDao(): SnipsDAO
    abstract fun unboxingDao(): UnboxingDAO
}