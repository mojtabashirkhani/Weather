package com.slimshady.weather.core


import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import androidx.multidex.MultiDex
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.slimshady.weather.di.component.DaggerCoreComponent


class App : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }
}
