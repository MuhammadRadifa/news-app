package com.example.newsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title:String,
    val link:String,
    val isoDate:String,
    val image:String,
    val description:String
):Parcelable

data class NewsResponse(val message:String,val total:Int,val data:List<News>)