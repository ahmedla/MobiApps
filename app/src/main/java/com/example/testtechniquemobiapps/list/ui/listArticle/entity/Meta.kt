package com.example.testtechniquemobiapps.list.ui.listArticle.entity

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("hits") val hits: Int?,
    @SerializedName("offset") val offset: Int?
)