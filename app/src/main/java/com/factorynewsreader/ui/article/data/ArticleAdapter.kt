package com.factorynewsreader.ui.article.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.databinding.ListItemArticleBinding

class ArticleAdapter : ListAdapter<Article, ArticleViewHolder>(ArticleDiffUtilCallback()) {

    lateinit var callback: (product: Article) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding, callback)
    }

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

}