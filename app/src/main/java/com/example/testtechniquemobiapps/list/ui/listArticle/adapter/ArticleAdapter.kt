package com.example.testtechniquemobiapps.list.ui.listArticle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testtechniquemobiapps.R
import com.example.testtechniquemobiapps.list.ui.listArticle.entity.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleAdapter(private val articleList: List<Article>,
                     private val listener: (Article) -> Unit) :

RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false) as ConstraintLayout

        return ArticleViewHolder(textView)
    }

    override fun getItemCount(): Int {

        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        holder.bindData(articleList[position], listener)
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(article: Article, listener: (Article) -> Unit) = with(itemView) {

            if (article.snippet != null) {
                itemView.titleTextView.text = article.snippet
            }

            article.thumbnail?.let {
                Picasso
                    .get()
                    .load(article.thumbnail)
                    .placeholder(R.mipmap.ic_logo)
                    .error(R.mipmap.ic_logo)
                    .into(itemView.iconImageView)
            }

            setOnClickListener { listener(article) }
        }

    }

}