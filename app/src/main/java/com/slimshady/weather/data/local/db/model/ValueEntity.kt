package com.slimshady.weather.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slimshady.weather.data.remote.model.places_response.Geom

@Entity(tableName = "Value")
data class ValueEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "address")
    var address: String? = "",

    @ColumnInfo(name = "city")
    var city: String? = "",

    @ColumnInfo(name = "county")
    var county: String? = "",

    @ColumnInfo(name = "district")
    var district: String? = "",

    @ColumnInfo(name = "fclass")
    var fclass: String? = "",

    @ColumnInfo(name = "geom")
    val geom: Geom?,

    @ColumnInfo(name = "neighborhood")
    var neighborhood: String? = "",

    @ColumnInfo(name = "province")
    var province: String? = "",

    @ColumnInfo(name = "region")
    var region: String? = "",

    @ColumnInfo(name = "title")
    var title: String? = "",

    @ColumnInfo(name = "type")
    var type: String?  = ""
)