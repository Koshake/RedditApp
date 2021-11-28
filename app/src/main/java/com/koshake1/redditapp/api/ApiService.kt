package com.koshake1.redditapp.api

import com.koshake1.redditapp.model.data.RedditResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/r/aww/hot.json")
    fun getHotData(): Deferred<RedditResponse>

    @GET("/r/aww/hot.json")
    fun getHotAfterData(
        @Query("after") after: String
    ): Deferred<RedditResponse>

    @GET("/r/aww/hot.json")
    fun getHotBeforeData(
        @Query("before") before: String
    ): Deferred<RedditResponse>

    @GET("/r/aww/hot.json")
    fun getHotBeforeAfterData(
        @Query("before") before: String,
        @Query("after") after: String
    ): Deferred<RedditResponse>

}