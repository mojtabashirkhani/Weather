package com.slimshady.weather.util

/**
 * Created by Furkan on 2019-10-26
 */

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
