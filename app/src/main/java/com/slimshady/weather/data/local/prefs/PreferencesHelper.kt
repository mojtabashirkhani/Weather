package com.slimshady.weather.data.local.prefs

interface PreferencesHelper {
    fun getSettings(): Settings
    fun setSettings(settings: Settings)
}