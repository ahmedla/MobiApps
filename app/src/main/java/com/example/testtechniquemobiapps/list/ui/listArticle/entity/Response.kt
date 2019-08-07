package com.example.testtechniquemobiapps.list.ui.listArticle.entity

import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("docs") val docs: List<Article>?,
                    @SerializedName("meta") val meta: Meta?)