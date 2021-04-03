package com.slimshady.weather.core

object Constants {

    object NetworkService {
        const val BASE_URL_WEATHER = "http://api.openweathermap.org/data/2.5/"
        const val BASE_URL_MAP = "https://maps.googleapis.com/maps/api/place/"
        const val API_KEY_WEATHER = "751d80f6c314139192ffcb62c107e654"
        const val RATE_LIMITER_TYPE = "data"
        const val API_KEY_QUERY_WEATHER = "appid"
        const val API_KEY_MAP = "AIzaSyBmuETnmGItitpoewCXGkv--oOioZj_Fmo"
        const val API_KEY_OAUTH = "667369541308-hmjgu7l2k3gis3k5ms88i7apflh4u6c5.apps.googleusercontent.com"
        const val PLACE_AUTOCOMPLETE_RADIUS = "3500"

    }

    object AlgoliaKeys {
        const val APPLICATION_ID = "plNW8IW0YOIN"
        const val SEARCH_API_KEY = "029766644cb160efa51f2a32284310eb"
    }

    object Coords {
        const val LAT = "lat"
        const val LON = "lon"
        const val METRIC = "metric"
    }
}