package com.example.testtechniquemobiapps.list.ui.listArticle.contract

import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Body

class MainContract{

    interface View {

        fun displayArticleList(ArticleList: List<Article>?)

        fun showError(message: Int)

        fun showProgress(mustShow: Boolean)
    }

    interface Presenter {

        fun onFetchArticleList()

        fun onDestroy()
    }

    interface Interactor {

        fun fetchArticleList()
    }

    interface InteractorOutput {

        fun onSuccessFetchArticleList(ArticleList: List<Article>?)

        fun onErrorFetchArticleList(message: Int)
    }

    interface Repository {

        fun fetchArticleListFromApi()
    }

    interface RepositoryOutput {

        fun onSuccessFetchArticleLisFromApi(body: Body?)


        fun onErrorFetchArticleListFromApi(message: Int)
    }
}