package com.example.testtechniquemobiapps.list.ui.listArticle.repository

import com.example.testtechniquemobiapps.R
import com.example.testtechniquemobiapps.list.ui.listArticle.contract.MainContract
import com.example.testtechniquemobiapps.list.ui.listArticle.api.RestClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainRepository (private var output: MainContract.RepositoryOutput) : MainContract.Repository {

    override fun fetchArticleListFromApi() {

        val service = RestClient.create()
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.getArticlesAsync()
            try {
                val response = request.await()
                if (response.isSuccessful) {
                    output.onSuccessFetchArticleLisFromApi(response.body())
                } else {
                    output.onErrorFetchArticleListFromApi(R.string.error_occurred)
                }
            } catch (e: HttpException) {
                output.onErrorFetchArticleListFromApi(R.string.error_no_internet_connexion)

            } catch (e: Throwable) {
                output.onErrorFetchArticleListFromApi(R.string.error_occurred)
            }
        }
    }
}
