package com.slimshady.weather.data.local.db.model

import android.os.Parcelable
import androidx.room.*

import com.slimshady.weather.data.remote.model.weather.ForecastResponse
import com.slimshady.weather.data.remote.model.weather.ListItem
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 2019-10-21
 */

@Parcelize
@Entity(tableName = "Forecast")
data class ForecastEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

   /* @Embedded
    var city: CityEntity?,*/

    @ColumnInfo(name = "list")
    var list: List<ListItem>?
) : Parcelable {

    @Ignore
    constructor(forecastResponse: ForecastResponse) : this(
        id = 0,
        list = forecastResponse.list
    )
}
