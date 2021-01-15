package com.factorynewsreader.ui.article.data

import androidx.recyclerview.widget.DiffUtil
import com.factorynewsreader.data.api.model.Article

class ArticleDiffUtilCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(
        oldItem: Article,
        newItem: Article
    ): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: Article,
        newItem: Article
    ): Boolean = oldItem.title == newItem.title
}