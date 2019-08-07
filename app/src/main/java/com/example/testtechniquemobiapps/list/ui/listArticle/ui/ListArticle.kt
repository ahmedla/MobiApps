package com.example.testtechniquemobiapps.list.ui.listArticle.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtechniquemobiapps.R
import com.example.testtechniquemobiapps.list.ui.details.ui.DetailActivity
import com.example.testtechniquemobiapps.list.ui.global.Utils
import com.example.testtechniquemobiapps.list.ui.listArticle.adapter.ArticleAdapter
import com.example.testtechniquemobiapps.list.ui.listArticle.contract.MainContract
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article
import com.example.testtechniquemobiapps.list.ui.listArticle.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class ListArticle : AppCompatActivity(), MainContract.View {

    private var presenter: MainContract.Presenter? = MainPresenter(this)

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter?.onFetchArticleList()
        viewManager = LinearLayoutManager(this)

        ArticleRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun displayArticleList(articleList: List<Article>?) {

        articleList?.let { item ->
            viewAdapter = ArticleAdapter(item) { itemClicked ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(Utils.ARTICLE, itemClicked)
                startActivity(intent)
            }
            ArticleRecyclerview.visibility = View.VISIBLE
            ArticleRecyclerview.also {
                it.adapter = viewAdapter
            }

        }
    }

    override fun showProgress(mustShow: Boolean) {

        when (mustShow) {
            true -> progressBar.visibility = View.VISIBLE
            else -> progressBar.visibility = View.GONE
        }
    }

    override fun showError(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
