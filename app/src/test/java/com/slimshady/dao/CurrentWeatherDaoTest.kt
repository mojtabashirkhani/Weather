package com.slimshady.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.slimshady.util.generateCurrentWeatherEntity
import com.slimshady.util.getOrAwaitValue
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.dao.CurrentWeatherDao
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class CurrentWeatherDaoTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase
    private lateinit var currentWeatherDao: CurrentWeatherDao

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        currentWeatherDao = appDatabase.currentWeatherDao()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun `empty database count must be zero`() {
        // When
        val count = currentWeatherDao.getCount()

        // Then
        Truth.assertThat(count).isEqualTo(0)
    }

    @Test
    fun `insert one entity and count must be one`() {
        currentWeatherDao.insertCurrentWeather(generateCurrentWeatherEntity("Tehran", 1))

        // When
        val count = currentWeatherDao.getCount()

        // Then
        Truth.assertThat(count).isEqualTo(1)
    }

    @Test
    fun `insert one entity and test get function`() {
        currentWeatherDao.insertCurrentWeather(generateCurrentWeatherEntity("Tehran", 1))

        val entity = currentWeatherDao.getCurrentWeather().getOrAwaitValue()
        Truth.assertThat(entity.name).isEqualTo("Tehran")
    }

    @Test
    fun `delete and insert a current weather`(){
        // when
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Tehran", 1))
        val count = currentWeatherDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Adana", 2))
        val newCount = currentWeatherDao.getCount()
        val value = currentWeatherDao.getCurrentWeather().getOrAwaitValue()
        Truth.assertThat(newCount).isEqualTo(1)
        Truth.assertThat(value.name).isEqualTo("Adana")
    }

    @Test
    fun `first insert a current weather then delete and count must be zero`(){
        // When
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Tehran", 1))
        val count = currentWeatherDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        currentWeatherDao.deleteCurrentWeather()
        val newCount = currentWeatherDao.getCount()
        Truth.assertThat(newCount).isEqualTo(0)
    }
}