package com.slimshady.weather.data.local.db.model

import android.os.Parcelable
import androidx.room.*
import com.slimshady.weather.data.remote.model.places_response.PredictionsItem
import com.slimshady.weather.data.remote.model.places_response.SearchResponse
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 *@author Burhan ud din ---> item table
 */
@Parcelize
@Entity(tableName = "SearchSelectedItem")
data class SearchEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "predictions")
    var predictionsItem: @RawValue List<PredictionsItem?>?


) : Parcelable {
    @Ignore
    constructor(searchResponse: SearchResponse) : this(
      id = 0,
      predictionsItem = searchResponse.predictions
    )


}

