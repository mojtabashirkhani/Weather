package com.slimshady.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.slimshady.util.createSampleForecastResponse
import com.slimshady.util.getOrAwaitValue
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.dao.ForecastDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class ForecastDaoTest {

    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase
    private lateinit var forecastDao: ForecastDao

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        forecastDao = appDatabase.forecastDao()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun `insert a forecast to forecast dao`() {
        // When
        forecastDao.insertForecast(createSampleForecastResponse(3))

        // Then
        val value = forecastDao.getCount()
        Truth.assertThat(value).isEqualTo(1)
    }

    @Test
    fun `insert two forecast to forecast dao and then delete all after this operations count must be 0`() {
        // When
        forecastDao.insertForecast(createSampleForecastResponse(3))
        forecastDao.insertForecast(createSampleForecastResponse(4))

        val value = forecastDao.getCount()
        Truth.assertThat(value).isEqualTo(2)

        // Then
        forecastDao.deleteAll()
        val newValue = forecastDao.getCount()
        Truth.assertThat(newValue).isEqualTo(0)
    }



}