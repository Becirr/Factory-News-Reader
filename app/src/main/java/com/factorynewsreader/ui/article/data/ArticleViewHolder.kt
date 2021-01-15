package com.factorynewsreader.ui.article.data

import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.factorynewsreader.R
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.databinding.ListItemArticleBinding

class ArticleViewHolder(
    private val binding: ListItemArticleBinding,
    private val callback: (product: Article) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Article) {
        // Click listener
        binding.root.setOnClickListener { callback(data) }

        // Title
        binding.article = data

        val textShader = LinearGradient(
            0f,
            0f,
            0f,
            binding.txtTitle.resources.getDimensionPixelSize(R.dimen.article_item_text_height) * 1f,
            intArrayOf(
                ContextCompat.getColor(binding.txtTitle.context, R.color.text_color),
                ContextCompat.getColor(binding.txtTitle.context, R.color.text_color_fade)
            ),
            floatArrayOf(0.5f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.txtTitle.paint.shader = textShader

        // Picture
        Glide.with(itemView.context)
            .asBitmap()
            .load(data.urlToImage)
            .centerCrop()
            .transition(BitmapTransitionOptions.withCrossFade())
            .into(binding.imgArticle)
    }
}