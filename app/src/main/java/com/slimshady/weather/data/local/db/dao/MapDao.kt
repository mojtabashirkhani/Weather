package com.slimshady.weather.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.slimshady.weather.data.local.db.model.MapEntity
import com.slimshady.weather.data.local.db.model.ValueEntity

@Dao
interface MapDao {

    @Query("SELECT * FROM SearchMapIR")
    fun getRecentSearches(): LiveData<MapEntity>

    /**
     *@author Burhan ud din ---> method used to add item searched
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchItem(mapEntity: MapEntity)
}