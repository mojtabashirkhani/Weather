package com.slimshady.weather.core

object Constants {

    object NetworkService {
        const val BASE_URL_WEATHER = "http://api.openweathermap.org/data/2.5/"
        const val BASE_URL_MAP = "https://map.ir/search/v2/autocomplete"
        const val API_KEY_WEATHER = "751d80f6c314139192ffcb62c107e654"
        const val RATE_LIMITER_TYPE = "data"
        const val API_KEY_QUERY_WEATHER = "appid"
        const val API_KEY_MAP = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImUwNTAzZjVjMmM4ZTcwMDRkMTk1ZTAxNmM1MTAxNzM4MzVkZTI5NDA0NjgyN2Y2NWYxMWQ1MmFhNDcyYzEyNzQwMjk3Yzg2YTg1Nzg3OTg3In0.eyJhdWQiOiIxMzk3NyIsImp0aSI6ImUwNTAzZjVjMmM4ZTcwMDRkMTk1ZTAxNmM1MTAxNzM4MzVkZTI5NDA0NjgyN2Y2NWYxMWQ1MmFhNDcyYzEyNzQwMjk3Yzg2YTg1Nzg3OTg3IiwiaWF0IjoxNjIwOTk0ODcwLCJuYmYiOjE2MjA5OTQ4NzAsImV4cCI6MTYyMzU4Njg3MCwic3ViIjoiIiwic2NvcGVzIjpbImJhc2ljIl19.Mp3396jFjp1DbWNJ9PlF2Mh-h-pBDZwg39rZ_r5-FvjxblT__KkFxT5cRf6gJav3QxrC6LLp0z0q7AytjX9PjytJvfhMUfaNiu_E297idpb9Ygj8ApijwtqvI4WP_ef7y0j9vyIp6qShw8zTXs0ZyGnxWN2uXW0DjKhnWUqvsC2cCSFiJ_dau3pxdWvh3D_KLh5RsPDQby1uiCPzVYmDTqePlPMq9DEGpld3SUYxdUl4-QwKhVGikxd6nwCTcAcOW7CR7My-gUCkAkisamLEpThmKbbX6zVwAy0XEj9_3CbuNsrq__PhScGAbfZH7DiZ9RpUiICHOXmfCNAnTlZUzg"
        const val PLACE_AUTOCOMPLETE_RADIUS = "3500"

    }

    object ApiRoutes {
        const val GOOGLE_PLACE_AUTOCOMPLETE = "/maps/api/place/autocomplete/json"
        const val GOOGLE_PLACE_DETAILS = "/maps/api/place/details/json"


    }

    object ApiFields {
        const val HEADER_ACCEPT_ENCODING = "Accept-Encoding: identity"

    }


    object Coords {
        const val LAT = "lat"
        const val LON = "lon"
        const val METRIC = "metric"
    }
}