package com.slimshady.weather.di.builder


import com.slimshady.weather.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment




}