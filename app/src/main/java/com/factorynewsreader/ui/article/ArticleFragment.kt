package com.factorynewsreader.ui.article

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import com.factorynewsreader.BR
import com.factorynewsreader.R
import com.factorynewsreader.databinding.FragmentArticleBinding
import com.factorynewsreader.di.component.AppComponent
import com.factorynewsreader.ui.article.data.ArticleAdapter
import com.factorynewsreader.ui.base.BaseFragment
import com.factorynewsreader.util.json
import javax.inject.Inject

class ArticleFragment :
    BaseFragment<FragmentArticleBinding, ArticleViewModel>(R.layout.fragment_article) {

    @Inject
    lateinit var articleAdapter: ArticleAdapter

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun getViewModel(factory: Factory): ArticleViewModel =
        ViewModelProvider(this, factory).get(ArticleViewModel::class.java)

    override fun getBindingVariable(): Int = BR.viewModel

    override fun setupUI() {
        dataBinding.listArticles.adapter = articleAdapter
        viewModel.getArticles(activity as Context)
    }

    override fun setupListeners() {
        articleAdapter.callback = { _, position ->
            findNavController().navigate(
                ArticleFragmentDirections.actionArticleFragmentToArticleDetailsFragment(
                    position,
                    ArrayList(articleAdapter.currentList.toList()).json()
                )
            )
        }
    }
}