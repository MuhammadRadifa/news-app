package com.example.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://berita-indo-api-next.vercel.app/api/antara-news/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val newsService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("terkini")
    suspend fun getNewsLatest():News
}