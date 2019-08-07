package com.example.testtechniquemobiapps.list.ui.listArticle.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    @SerializedName("web_url") val webUrl: String?,
    @SerializedName("snippet") val snippet: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("lead_paragraph") val leadParagraph: String?,
    @SerializedName("abstract") val abstract: String?): Parcelable