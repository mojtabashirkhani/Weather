package com.slimshady.weather.di.module

import android.app.Application
import androidx.room.Room
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.AppDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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

   /* @Provides
    fun provideTimetableDao(database: AppDatabase): TimetableDao {
        return database.timetableDao()
    }

    @Provides
    fun provideTimetableRepository(database: AppDatabase): TimetableRepository {
        return TimetableRepositoryImpl(database)
    }
*/

}