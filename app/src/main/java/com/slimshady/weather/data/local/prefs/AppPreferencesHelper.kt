package com.slimshady.weather.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.slimshady.weather.di.qualifier.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper : PreferencesHelper {

    private val PREF_KEY_SETTINGS = "PREF_KEY_SETTINGS"
    private lateinit var prefs: SharedPreferences
    private lateinit var gson: Gson

    @Inject
    fun AppPreferencesHelper(
        context: Context,
        @PreferenceInfo prefFileName: String?
    ) {
        prefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        gson = Gson()
    }

    override fun getSettings(): Settings {
        return gson.fromJson(
            prefs.getString(
                PREF_KEY_SETTINGS,
                null
            ),
            Settings::class.java
        )
    }

    override fun setSettings(settings: Settings) {
        val json = gson.toJson(settings)
        prefs.edit().putString(
            PREF_KEY_SETTINGS,
            json
        ).apply()
    }

    companion object {
        const val PREF_NAME = "to_do_reminder_pref"
    }
}