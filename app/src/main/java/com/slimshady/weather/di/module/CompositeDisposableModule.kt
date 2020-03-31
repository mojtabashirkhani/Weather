package com.slimshady.weather.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class CompositeDisposableModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable{
        return CompositeDisposable()
    }

}