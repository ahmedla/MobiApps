package com.example.testtechniquemobiapps.list.ui.details.contract

import android.content.Intent
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article

class DetailContract {
    interface View {

        fun displayDetailArticle(article: Article?)
    }

    interface Presenter {

        fun onFetchArticle(intent: Intent?)

        fun onDestroy()
    }
}