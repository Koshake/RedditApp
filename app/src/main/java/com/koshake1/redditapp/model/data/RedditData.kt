package com.koshake1.redditapp.model.data

data class RedditData(
    val after:String? = null,
    val before:String? = null,
    val dist:Int? = 0,
    val children: List<Children>? = null
)
