package com.slimshady.weather.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.slimshady.weather.data.local.db.AppDatabase.Companion.VERSION
import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.dao.MapDao
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.util.typeconverters.DataConverter

@Database(
    entities = [ForecastEntity::class,
        CurrentWeatherEntity::class,
               MapEntity::class],
    version = VERSION,
    exportSchema = false
)

@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao
    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun mapDao(): MapDao

    companion object {
        const val DB_NAME = "weather.db"
        const val VERSION = 3
    }
}