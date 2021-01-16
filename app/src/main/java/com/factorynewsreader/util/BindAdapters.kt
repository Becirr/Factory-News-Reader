package com.factorynewsreader.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.ui.article.data.ArticleAdapter

@BindingAdapter("isVisible")
fun bindVisibility(
    view: View,
    visible: Boolean
) {
    view.visibility = when {
        visible -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("bindArticles")
fun bindArticles(
    view: RecyclerView,
    items: List<Article>?
) {
    val adapter = view.adapter
    if (adapter is ArticleAdapter && items != null) {
        adapter.submitList(items)
    }
}