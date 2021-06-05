package com.slimshady.weather.di.module

import android.app.Application
import androidx.room.Room
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.AppDatabase.Companion.DB_NAME
import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.dao.MapDao
import com.slimshady.weather.data.local.db.dao.RecentSearchesDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class qDatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideForecastDao(db: AppDatabase): ForecastDao {
        return db.forecastDao()
    }

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(db: AppDatabase): CurrentWeatherDao {
        return db.currentWeatherDao()
    }

    @Singleton
    @Provides
    fun provideRecentSearchDao(db: AppDatabase): RecentSearchesDAO {
        return db.recentSearchDao()
    }

    @Singleton
    @Provides
    fun provideMapDao(db: AppDatabase): MapDao {
        return db.mapDao()
    }

}