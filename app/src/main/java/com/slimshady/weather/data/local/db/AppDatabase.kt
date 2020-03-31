package com.slimshady.weather.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slimshady.weather.data.local.db.AppDatabase.Companion.VERSION
import com.slimshady.weather.data.local.db.dao.MainDao
import com.slimshady.weather.data.local.db.model.MainEntity

@Database(
    entities = [MainEntity::class],
    version = VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mainDao(): MainDao

    companion object {
        const val DB_NAME = "weather.db"
        const val VERSION = 1
    }
}