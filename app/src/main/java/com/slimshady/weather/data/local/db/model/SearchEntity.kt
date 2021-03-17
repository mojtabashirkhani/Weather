package com.slimshady.weather.data.local.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
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
):  Parcelable