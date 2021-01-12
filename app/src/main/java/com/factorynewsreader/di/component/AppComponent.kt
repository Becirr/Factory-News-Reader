package com.factorynewsreader.di.component

import com.factorynewsreader.App
import com.factorynewsreader.di.module.ApiModule
import com.factorynewsreader.di.module.AppModule
import com.factorynewsreader.di.module.DatabaseModule
import com.factorynewsreader.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        ApiModule::class,
        AppModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    fun inject(app: App)
}