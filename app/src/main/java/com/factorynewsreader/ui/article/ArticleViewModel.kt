package com.factorynewsreader.ui.article

import android.content.Context
import androidx.databinding.ObservableField
import com.factorynewsreader.data.api.model.Article
import com.factorynewsreader.data.repository.ArticleRepository
import com.factorynewsreader.ui.base.BaseViewModel
import com.factorynewsreader.util.showErrorDialog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : BaseViewModel() {

    val showLoading = ObservableField<Boolean>()
    val articles = ObservableField<List<Article>>()

    fun getArticles(context: Context) {
        val disposable = articleRepository.getArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .subscribe(
                { handleResponse(it) },
                { showErrorDialog(context) { showLoading.set(false) } })
        addSubscription(disposable)
    }

    private fun showLoading() {
        showLoading.set(true)
    }

    private fun handleResponse(results: List<Article>) {
        showLoading.set(false)
        articles.set(results)
    }

}