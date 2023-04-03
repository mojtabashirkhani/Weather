package com.slimshady.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
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

}