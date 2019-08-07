package com.example.testtechniquemobiapps.list.ui.listArticle.presenter

import com.example.testtechniquemobiapps.list.ui.listArticle.contract.MainContract
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article
import com.example.testtechniquemobiapps.list.ui.listArticle.interactor.MainInteractor

class MainPresenter(private var view: MainContract.View?) : MainContract.Presenter, MainContract.InteractorOutput {

    private var interactor: MainContract.Interactor? = MainInteractor(this)

    override fun onFetchArticleList() {

        view?.showProgress(true)

        interactor?.fetchArticleList()
    }

    override fun onSuccessFetchArticleList(articleList: List<Article>?) {

        view?.showProgress(false)

        view?.displayArticleList(articleList)
    }

    override fun onErrorFetchArticleList(message: Int) {

        view?.showProgress(false)

        view?.showError(message)
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }
}