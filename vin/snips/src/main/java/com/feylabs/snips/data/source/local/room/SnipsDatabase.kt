package com.feylabs.snips.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.feylabs.snips.data.source.local.dao.SnipsDAO
import com.feylabs.snips.data.source.local.entity.SnipsEntity


@Database(
    entities = [SnipsEntity::class], version = 168
)
abstract class SnipsDatabase : RoomDatabase() {
    abstract fun snipsDao(): SnipsDAO
}