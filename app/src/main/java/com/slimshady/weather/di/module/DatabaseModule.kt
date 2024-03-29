package com.slimshady.weather.di.module

import android.app.Application
import androidx.room.Room
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.AppDatabase.Companion.DB_NAME
import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.dao.MapDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideForecastDao(db: AppDatabase): ForecastDao {
        return db.forecastDao()
    }

    @Provides
    fun provideCurrentWeatherDao(db: AppDatabase): CurrentWeatherDao {
        return db.currentWeatherDao()
    }


    @Provides
    fun provideMapDao(db: AppDatabase): MapDao {
        return db.mapDao()
    }

}