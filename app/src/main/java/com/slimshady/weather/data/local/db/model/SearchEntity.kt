package com.slimshady.weather.data.local.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import com.slimshady.weather.data.remote.model.weather.ForecastResponse
import kotlinx.android.parcel.Parcelize

/**
 *@author Burhan ud din ---> item table
 */
@Parcelize
@Entity(tableName = "SearchSelectedItem")
data class SearchEntity(
    @PrimaryKey var placeId: String,
    var mainText: String,
    var secondaryText: String,
    var searchCurrentMilliseconds: Long
) : Parcelable {
    @Ignore
    constructor(searchResponse: SearchResponse) : this(
        placeId = "0",
        mainText = searchResponse.predictions?.get(0)?.structuredFormatting?.mainText.toString(),
        secondaryText = searchResponse.predictions?.get(0)?.structuredFormatting?.secondaryText.toString(),
        searchCurrentMilliseconds = System.currentTimeMillis()
    )


}

