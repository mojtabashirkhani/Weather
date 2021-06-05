package com.slimshady.weather.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SearchMapIR")
data class MapEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int
)

   /* @ColumnInfo(name = "value")
    var value: @RawValue List<Value?>?


) : Parcelable {
    @Ignore
    constructor(searchResponse: MapIR) : this(
        id = 0,
        value = searchResponse.value
    )*/



