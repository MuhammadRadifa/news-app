package com.example.newsapp

import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun convertTime(isoDate:String):String{
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)

    val instant = Instant.parse(isoDate)
    val zonedDateTime = ZonedDateTime.ofInstant(instant, java.time.ZoneOffset.UTC)

    return zonedDateTime.format(formatter)
}
