package com.slimshady.weather.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.slimshady.weather.data.local.db.model.SearchEntity

/**
 *@author Burhan ud din ---> Data access Object
 */
@Dao
interface RecentSearchesDAO {

    /**
     *@author Burhan ud din ---> method used to get recent searches list
     */
    @Query("SELECT * FROM SearchSelectedItem ORDER BY searchCurrentMilliseconds DESC")
    fun getRecentSearches(): List<SearchEntity>

    /**
     *@author Burhan ud din ---> method used to add item searched
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchItem(searchEntity: SearchEntity)

}