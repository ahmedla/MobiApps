package com.example.testtechniquemobiapps.list.ui.details.presenter

import android.content.Intent
import com.example.testtechniquemobiapps.list.ui.details.contract.DetailContract
import com.example.testtechniquemobiapps.list.ui.global.Utils
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article

class DetailPresenter(private var view: DetailContract.View?) : DetailContract.Presenter {

    override fun onFetchArticle(intent: Intent?) {

        if (intent != null && intent.extras != null) {
            val article: Article = intent.getParcelableExtra(Utils.ARTICLE)
            view?.displayDetailArticle(article)
        }
    }

    override fun onDestroy() {
        view = null
    }
}