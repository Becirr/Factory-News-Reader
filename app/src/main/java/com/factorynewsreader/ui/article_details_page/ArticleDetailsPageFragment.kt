package com.factorynewsreader.ui.article_details_page

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.factorynewsreader.BR
import com.factorynewsreader.R
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.databinding.FragmentArticleDetailsPageBinding
import com.factorynewsreader.di.component.AppComponent
import com.factorynewsreader.ui.base.BaseFragment
import com.factorynewsreader.util.fromJson

class ArticleDetailsPageFragment :
    BaseFragment<FragmentArticleDetailsPageBinding, ArticleDetailsPageViewModel>(R.layout.fragment_article_details_page) {

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun getViewModel(factory: ViewModelProvider.Factory): ArticleDetailsPageViewModel =
        ViewModelProvider(this, factory).get(ArticleDetailsPageViewModel::class.java)

    override fun getBindingVariable(): Int = BR.viewModel

    override fun setupUI() {
        val article = arguments?.getString("article")?.fromJson<Article>()

        // Info
        dataBinding.article = article

        // Image
        Glide.with(this)
            .load(article?.urlToImage)
            .into(dataBinding.img)
    }

    override fun setupListeners() {

    }

    companion object {
        fun newInstance(article: String): ArticleDetailsPageFragment {
            return ArticleDetailsPageFragment().apply {
                val args = Bundle()
                args.putString("article", article)
                arguments = args
            }
        }
    }

}