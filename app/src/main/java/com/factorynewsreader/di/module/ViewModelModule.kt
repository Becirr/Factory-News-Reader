package com.factorynewsreader.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.factorynewsreader.di.ViewModelProviderFactory
import com.factorynewsreader.di.key.ViewModelKey
import com.factorynewsreader.ui.article.ArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun bindsArticleViewModel(viewModel: ArticleViewModel): ViewModel

}