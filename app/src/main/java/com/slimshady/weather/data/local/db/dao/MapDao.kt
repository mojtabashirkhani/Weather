package com.slimshady.weather.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.slimshady.weather.data.local.db.model.ForecastEntity
import com.slimshady.weather.data.local.db.model.MapEntity

@Dao
interface MapDao {

    @Query("SELECT * FROM SearchMapIR")
    fun getRecentSearches(): LiveData<MapEntity>

    /**
     *@author Burhan ud din ---> method used to add item searched
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchItem(mapEntity: MapEntity)

    @Query("Select count(*) from SearchMapIR")
    fun getCount(): Int

    @Update
    fun updateSearchMapResult(mapEntity: MapEntity)

    @Delete
    fun deleteSearchMapResult(mapEntity: MapEntity)

    @Query("DELETE FROM SearchMapIR")
    fun deleteAll()
}