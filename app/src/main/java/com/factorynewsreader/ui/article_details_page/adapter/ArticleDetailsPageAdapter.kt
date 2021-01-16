package com.factorynewsreader.ui.article_details_page.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.ui.article_details_page.ArticleDetailsPageFragment
import com.factorynewsreader.util.json

class ArticleDetailsPageAdapter(
    fragmentActivity: FragmentActivity,
    private val articles: ArrayList<Article>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = articles.size

    override fun createFragment(position: Int): Fragment = ArticleDetailsPageFragment.newInstance(
        articles[position].json()
    )

}