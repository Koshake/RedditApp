package com.koshake1.redditapp.model.data

data class RedditData(
    val after:String,
    val before:String,
    val dist:Int = 0,
    val children: List<Children>
)
