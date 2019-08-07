package com.example.testtechniquemobiapps.list.ui.listArticle.api

import com.example.testtechniquemobiapps.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory

class RestClient {

    companion object {

        fun create(): ApiServiceInterface {

            val builder = OkHttpClient().newBuilder()
            builder.addInterceptor { chain ->
                var origin = chain.request()
                val url = origin.url().newBuilder().addQueryParameter("api-key", BuildConfig.BASE_TOKEN).build()
                origin = origin.newBuilder().url(url).build()
                chain.proceed(origin)
            }
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(builder.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}