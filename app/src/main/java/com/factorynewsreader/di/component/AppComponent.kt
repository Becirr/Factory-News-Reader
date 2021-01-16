package com.factorynewsreader.di.component

import com.factorynewsreader.App
import com.factorynewsreader.di.module.ApiModule
import com.factorynewsreader.di.module.AppModule
import com.factorynewsreader.di.module.DatabaseModule
import com.factorynewsreader.di.module.ViewModelModule
import com.factorynewsreader.ui.article.ArticleFragment
import com.factorynewsreader.ui.article_details.ArticleDetailsFragment
import com.factorynewsreader.ui.article_details_page.ArticleDetailsPageFragment
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
    fun inject(articleFragment: ArticleFragment)
    fun inject(articleDetailsFragment: ArticleDetailsFragment)
    fun inject(articleDetailsPageFragment: ArticleDetailsPageFragment)
}