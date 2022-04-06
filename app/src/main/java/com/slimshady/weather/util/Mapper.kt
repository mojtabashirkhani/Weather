package com.slimshady.weather.util


interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
