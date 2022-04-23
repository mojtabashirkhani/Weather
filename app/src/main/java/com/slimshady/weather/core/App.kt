package com.slimshady.weather.core


import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate();
        Picasso.setSingletonInstance(Picasso.Builder(this).build())

    }

 /*   override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }*/

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }


}
