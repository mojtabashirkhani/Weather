package com.slimshady.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.slimshady.util.createSampleForecastResponse
import com.slimshady.util.generateMapEntity
import com.slimshady.util.getOrAwaitValue
import com.slimshady.weather.data.local.db.AppDatabase
import com.slimshady.weather.data.local.db.dao.ForecastDao
import com.slimshady.weather.data.local.db.dao.MapDao
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class MapDaoTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase
    private lateinit var mapDao: MapDao

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        mapDao = appDatabase.mapDao()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @Test
    fun `empty database count must be zero`() {
        // When
        val count = mapDao.getCount()

        // Then
        Truth.assertThat(count).isEqualTo(0)
    }

    @Test
    fun `insert a search map result to map dao`() {
        // When
        mapDao.addSearchItem(generateMapEntity(3, "Tehran"))

        // Then
        val value = mapDao.getCount()
        Truth.assertThat(value).isEqualTo(1)
    }

    @Test
    fun `insert two search map result to map dao and then delete all after this operations count must be 0`() {
        // When
        mapDao.addSearchItem(generateMapEntity(3, "Tehran"))
        mapDao.addSearchItem(generateMapEntity(4, "Mashad"))

        val value = mapDao.getCount()
        Truth.assertThat(value).isEqualTo(2)

        // Then
        mapDao.deleteAll()
        val newValue = mapDao.getCount()
        Truth.assertThat(newValue).isEqualTo(0)
    }

    @Test
    fun `insert a map and then update`() {
        // When
        mapDao.addSearchItem(generateMapEntity(1, "Tehran"))
        val firstValue = mapDao.getRecentSearches().getOrAwaitValue()
        Truth.assertThat(firstValue.value?.get(0)?.city).isEqualTo("Tehran")

        // Then
        mapDao.updateSearchMapResult(generateMapEntity(1, "Mashad"))
        val updatedValue = mapDao.getRecentSearches().getOrAwaitValue()
        Truth.assertThat(updatedValue.value?.get(0)?.city).isEqualTo("Mashad")
    }

    @Test
    fun `first insert a forecast then delete and count must be zero`() {
        // When
        mapDao.addSearchItem(generateMapEntity(1, "Mashad"))
        val count = mapDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        mapDao.deleteSearchMapResult(generateMapEntity(1, "Mashad"))
        val newCount = mapDao.getCount()
        Truth.assertThat(newCount).isEqualTo(0)
    }

}