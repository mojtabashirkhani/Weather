package com.slimshady.weather.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CompositeDisposableModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable{
        return CompositeDisposable()
    }

}