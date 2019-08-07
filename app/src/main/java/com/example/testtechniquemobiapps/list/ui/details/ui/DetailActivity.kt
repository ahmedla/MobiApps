package com.example.testtechniquemobiapps.list.ui.details.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testtechniquemobiapps.R
import com.example.testtechniquemobiapps.list.ui.details.contract.DetailContract
import com.example.testtechniquemobiapps.list.ui.details.presenter.DetailPresenter
import com.example.testtechniquemobiapps.list.ui.global.Utils
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.*
import kotlinx.android.synthetic.main.article_item.iconImageView
import kotlinx.android.synthetic.main.article_item.titleTextView
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity(), DetailContract.View {

    private var presenter: DetailContract.Presenter? = DetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        presenter?.onFetchArticle(intent)
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun displayDetailArticle(article: Article?) {

        article?.let {
            titleTextView.text = it.snippet
            it.thumbnail?.let { th ->
                Picasso
                    .get()
                    .load(th)
                    .placeholder(R.mipmap.ic_logo)
                    .error(R.mipmap.ic_logo)
                    .into(iconImageView)
            }
        }

    }

}
