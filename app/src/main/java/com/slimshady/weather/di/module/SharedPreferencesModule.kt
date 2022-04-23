package com.slimshady.weather.di.module


import com.slimshady.weather.data.local.prefs.AppPreferencesHelper
import com.slimshady.weather.data.local.prefs.AppPreferencesHelper.Companion.PREF_NAME
import com.slimshady.weather.data.local.prefs.PreferencesHelper
import com.slimshady.weather.di.qualifier.PreferenceInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SharedPreferencesModule {

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }
}