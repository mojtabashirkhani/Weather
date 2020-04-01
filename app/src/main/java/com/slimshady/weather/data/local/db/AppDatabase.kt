package com.slimshady.weather.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.slimshady.weather.data.local.db.AppDatabase.Companion.VERSION
import com.slimshady.weather.data.local.db.dao.CitiesForSearchDao
import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.model.CitiesForSearchEntity
import com.slimshady.weather.data.local.db.model.CurrentWeatherEntity
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.data.local.db.model.MainEntity
import com.slimshady.weather.util.typeconverters.DataConverter

@Database(
    entities = [ForecastEntity::class,
        CurrentWeatherEntity::class,
        CitiesForSearchEntity::class],
    version = VERSION,
    exportSchema = false
)

@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao
    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun citiesForSearchDao(): CitiesForSearchDao

    companion object {
        const val DB_NAME = "weather.db"
        const val VERSION = 1
    }
}