package com.slimshady.weather.util.domain

import android.os.Build
import android.os.SystemClock
import android.util.ArrayMap
import androidx.annotation.RequiresApi
import java.util.concurrent.TimeUnit


/**
 * Utility class that decides whether we should fetch some data or not.
 */
class RateLimiter<in KEY>(timeout: Int, timeUnit: TimeUnit) {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private val timestamps = ArrayMap<KEY, Long>()
    private val timeout = timeUnit.toMillis(timeout.toLong())

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Synchronized
    fun shouldFetch(key: KEY): Boolean {
        val lastFetched = timestamps[key]
        val now = now()
        if (lastFetched == null) {
            timestamps[key] = now
            return true
        }
        if (now - lastFetched > timeout) {
            timestamps[key] = now
            return true
        }
        return false
    }

    private fun now() = SystemClock.uptimeMillis()

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Synchronized
    fun reset(key: KEY) {
        timestamps.remove(key)
    }
}
