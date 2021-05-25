package com.slimshady.weather.data.local.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.slimshady.weather.data.remote.model.places_response.MapIR
import com.slimshady.weather.data.remote.model.places_response.Value
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "SearchMapIR")
data class MapEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "value")
    var value: @RawValue List<Value?>?


) : Parcelable {
    @Ignore
    constructor(searchResponse: MapIR) : this(
        id = 0,
        value = searchResponse.value
    )
}


