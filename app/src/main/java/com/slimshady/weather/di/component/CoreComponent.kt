package com.slimshady.weather.di.component

import android.app.Application

import com.slimshady.weather.core.App
import com.slimshady.weather.di.builder.ActivityBuilder
import com.slimshady.weather.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class,
        DatabaseModule::class, ContextModule::class, CompositeDisposableModule::class,
        SharedPreferencesModule::class, NetworkModule::class]
)
interface CoreComponent : AndroidInjector<App> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent


    }


}