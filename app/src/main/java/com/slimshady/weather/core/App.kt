package com.slimshady.weather.core


import android.content.Context
import androidx.multidex.MultiDex
import com.slimshady.weather.di.component.DaggerCoreComponent
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate();
        Picasso.setSingletonInstance(Picasso.Builder(this).build())

    }


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
