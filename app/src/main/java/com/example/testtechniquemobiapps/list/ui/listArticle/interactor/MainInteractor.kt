package com.example.testtechniquemobiapps.list.ui.listArticle.interactor

import com.example.testtechniquemobiapps.list.ui.listArticle.contract.MainContract
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Body
import com.example.testtechniquemobiapps.list.ui.listArticle.repository.MainRepository

class MainInteractor(private var output: MainContract.InteractorOutput) : MainContract.Interactor, MainContract.RepositoryOutput {

    private val repository: MainContract.Repository = MainRepository(this)

    override fun onSuccessFetchArticleLisFromApi(body: Body?) {
        output.onSuccessFetchArticleList(body?.response?.docs)
    }

    override fun onErrorFetchArticleListFromApi(message: Int) {
        output.onErrorFetchArticleList(message)
    }

    override fun fetchArticleList() {
        // Logic business
        repository.fetchArticleListFromApi()
    }
}