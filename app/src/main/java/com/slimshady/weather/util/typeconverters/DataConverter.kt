package com.slimshady.weather.util.typeconverters

import androidx.room.TypeConverter
import com.slimshady.weather.data.remote.model.places_response.PredictionsItem
import com.slimshady.weather.data.remote.model.weather.ListItem
import com.slimshady.weather.data.remote.model.weather.WeatherItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Created by Furkan on 2019-10-21
 */

object DataConverter {

    @TypeConverter
    @JvmStatic
    fun stringToList(data: String?): List<ListItem>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ListItem::class.java)
        val adapter = moshi.adapter<List<ListItem>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun listToString(objects: List<ListItem>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ListItem::class.java)
        val adapter = moshi.adapter<List<ListItem>>(type)
        return adapter.toJson(objects)
    }

    @TypeConverter
    @JvmStatic
    fun weatherStringToList(data: String?): List<WeatherItem>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, WeatherItem::class.java)
        val adapter = moshi.adapter<List<WeatherItem>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun weatherListToString(objects: List<WeatherItem>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, WeatherItem::class.java)
        val adapter = moshi.adapter<List<WeatherItem>>(type)
        return adapter.toJson(objects)
    }

    @TypeConverter
    @JvmStatic
    fun predictionsItemStringToList(data: String?): List<PredictionsItem>? {
        if (data == null) {
            return emptyList()
        }

        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, PredictionsItem::class.java)
        val adapter = moshi.adapter<List<PredictionsItem>>(type)
        return adapter.fromJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun predictionsItemListToString(objects: List<PredictionsItem>): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, PredictionsItem::class.java)
        val adapter = moshi.adapter<List<PredictionsItem>>(type)
        return adapter.toJson(objects)
    }
}
