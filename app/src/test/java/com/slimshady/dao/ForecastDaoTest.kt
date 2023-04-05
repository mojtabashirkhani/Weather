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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class ForecastDaoTest {

    @Rule
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

    @Test
    fun `insert a forecast and then update`() {
        // When
        forecastDao.insertForecast(createSampleForecastResponse(1, "cloud"))
        val value = forecastDao.getForecast().getOrAwaitValue()
        Truth.assertThat(value.list?.get(0)?.weather?.get(0)?.description).isEqualTo("cloud")

        // Then
        forecastDao.updateForecast(createSampleForecastResponse(1, "rain"))
        val updatedValue = forecastDao.getForecast().getOrAwaitValue()
        Truth.assertThat(updatedValue.list?.get(0)?.weather?.get(0)?.description).isEqualTo("rain")
    }

    @Test
    fun `delete and insert a forecast`() {
        // When
        forecastDao.insertForecast(createSampleForecastResponse(1, "cloud"))
        val count = forecastDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        forecastDao.deleteAndInsert(createSampleForecastResponse(2, "rain"))
        val newCount = forecastDao.getCount()
        val value = forecastDao.getForecast().getOrAwaitValue()
        Truth.assertThat(newCount).isEqualTo(1)
        Truth.assertThat(value.list?.get(0)?.weather?.get(0)?.description).isEqualTo("rain")
    }

    @Test
    fun `first insert a forecast then delete and count must be zero`() {
        // When
        forecastDao.insertForecast(createSampleForecastResponse(1, "rain"))
        val count = forecastDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        forecastDao.deleteForecast(createSampleForecastResponse(1, "rain"))
        val newCount = forecastDao.getCount()
        Truth.assertThat(newCount).isEqualTo(0)
    }

}