package com.factorynewsreader.di.module

import com.factorynewsreader.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    internal fun providesApp(): App = app
}