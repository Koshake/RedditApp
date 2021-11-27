package com.koshake1.redditapp.api

import com.koshake1.redditapp.model.data.RedditResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/r/aww/hot.json")
    fun getHotData() : Deferred<RedditResponse>
}