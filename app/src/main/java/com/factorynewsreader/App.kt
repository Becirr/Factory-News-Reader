package com.factorynewsreader

import android.app.Application
import com.factorynewsreader.di.component.AppComponent
import com.factorynewsreader.di.component.DaggerAppComponent
import com.factorynewsreader.di.module.ApiModule
import com.factorynewsreader.di.module.AppModule
import com.factorynewsreader.di.module.DatabaseModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLogging()
        setupDagger()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupDagger() {
        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(this))
            .apiModule(ApiModule(this))
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}