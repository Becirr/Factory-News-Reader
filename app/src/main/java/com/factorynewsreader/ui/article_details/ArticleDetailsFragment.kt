package com.factorynewsreader.ui.article_details

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.factorynewsreader.BR
import com.factorynewsreader.R
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.databinding.FragmentArticleDetailsBinding
import com.factorynewsreader.di.component.AppComponent
import com.factorynewsreader.ui.article_details_page.adapter.ArticleDetailsPageAdapter
import com.factorynewsreader.ui.base.BaseFragment
import com.factorynewsreader.util.fromJsonList


class ArticleDetailsFragment :
    BaseFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>(R.layout.fragment_article_details) {

    private val args: ArticleDetailsFragmentArgs by navArgs()
    private lateinit var articleList: ArrayList<Article>

    private val onPageChanged = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            dataBinding.title.text = articleList[position].title
        }
    }

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun getViewModel(factory: Factory): ArticleDetailsViewModel =
        ViewModelProvider(this, factory).get(ArticleDetailsViewModel::class.java)

    override fun getBindingVariable(): Int = BR.viewModel

    override fun setupUI() {
        articleList = args.articleList.fromJsonList()
        val position = args.position

        dataBinding.title.isSelected = true

        dataBinding.pager.adapter = activity?.let { ArticleDetailsPageAdapter(it, articleList) }
        dataBinding.pager.registerOnPageChangeCallback(onPageChanged)
        dataBinding.pager.currentItem = position
    }

    override fun setupListeners() {
        dataBinding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dataBinding.pager.unregisterOnPageChangeCallback(onPageChanged)
    }
}